package br.com.ericandrade.hearthstoneapi.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.databinding.ActivityHomeBinding
import br.com.ericandrade.hearthstoneapi.domain.general.CardInformation
import br.com.ericandrade.hearthstoneapi.ui.home.viewModel.HomeViewModel
import org.koin.android.ext.android.inject
import androidx.lifecycle.Observer
import br.com.ericandrade.hearthstoneapi.domain.general.Basic

class HomeActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by inject()

    private val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        ) as ActivityHomeBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        setObservables()
        setView()
        setEvents()
    }

    private fun setObservables() {
        viewModel.cardsListLiveData.observe(
            this,
            Observer { cardTypeList ->


            }
        )

        viewModel.cardLiveData.observe(
            this,
            Observer { card ->
                setupCards(card)
            }
        )
    }

    private fun setupCards(card: List<Basic>) {
        val cardsCategories = resources.getStringArray(R.array.cards_categories)
        val cards = setCardInformationList(cardsCategories, card)
        val listGroup = setCategoryAndCardInformation(cards)

        binding.cardCategoryRecyclerView.adapter = CardCategoryAdapter(
            listGroup,
            ::onClickCardCategory
        )
    }

    private fun setCardInformationList(
        cardsCategories: Array<out String>,
        card: List<Basic>
    ): MutableList<CardInformation> {
        val cardInformationList = mutableListOf<CardInformation>()

        cardsCategories.forEach {
            cardInformationList.add(CardInformation(it, card))
        }
        return cardInformationList
    }

    private fun setCategoryAndCardInformation(cardInformationList: MutableList<CardInformation>): ArrayList<Pair<Int, CardInformation>> {
        val sortedList = cardInformationList.groupBy { it.category }
        val listGroup = ArrayList<Pair<Int, CardInformation>>()

        for ((k, v) in sortedList) {
            listGroup.add(Pair(0, v.first()))
            v.forEach { cardCategory ->
                listGroup.add(Pair(1, cardCategory))
            }
        }
        return listGroup
    }

    private fun setView() {
        viewModel.getCards()
    }

    private fun setEvents() {
        binding.titleToolbarTextView.setOnClickListener {
            Toast.makeText(this, getString(R.string.size_name), Toast.LENGTH_SHORT).show()
        }
    }

    private fun onClickCardCategory(cardBasic: Basic) {
        Toast.makeText(this, cardBasic.playerClass, Toast.LENGTH_SHORT).show()
    }
}