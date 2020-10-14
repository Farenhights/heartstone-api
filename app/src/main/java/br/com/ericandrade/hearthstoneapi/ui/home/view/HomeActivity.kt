package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.content.Intent
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
import br.com.ericandrade.hearthstoneapi.ui.base.BaseActivity
import br.com.ericandrade.hearthstoneapi.ui.cards.view.CardsActivity

class HomeActivity : BaseActivity() {

    private val viewModel: HomeViewModel by inject()

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
        setBinding()
        setView()
        setObservables()
        setEvents()
    }

    private fun setBinding() {
        binding.viewModel = viewModel
    }

    private fun setView() {
        binding.viewModel!!.getCards()
    }

    private fun setObservables() {
        binding.viewModel!!.loadingLiveData.observe(this@HomeActivity, Observer { shouldShow ->
            showIndeterminateProgressDialog(R.string.wait, shouldShow)
        })

        binding.viewModel!!.cardBasicInformationListLiveData.observe(
            this,
            Observer { cardBasicInformationList ->
                setupCardInformationList(cardBasicInformationList)
            }
        )
    }

    private fun setupCardInformationList(cardBasicInformationList: List<Basic>) {
        val cardCategories = resources.getStringArray(R.array.cards_categories)
        val cardInformationList = loadCardInformationList(cardCategories, cardBasicInformationList)
        val listGroup = setCategoryAndCardInformation(cardInformationList)

        setAdapter(listGroup)
    }

    private fun loadCardInformationList(
        cardCategories: Array<out String>,
        cardBasicInformationList: List<Basic>
    ): MutableList<CardInformation> {
        val cardInformationList = mutableListOf<CardInformation>()

        cardCategories.forEach {
            cardInformationList.add(CardInformation(it, cardBasicInformationList))
        }
        return cardInformationList
    }

    private fun setCategoryAndCardInformation(
        cardInformationList: MutableList<CardInformation>
    ): ArrayList<Pair<Int, CardInformation>> {
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

    private fun setAdapter(listGroup: ArrayList<Pair<Int, CardInformation>>) {
        binding.cardCategoryRecyclerView.adapter = CardCategoryAdapter(
            listGroup,
            ::onClickCardCategory
        )
    }

    private fun setEvents() {
        binding.titleToolbarTextView.setOnClickListener {
            Toast.makeText(this, getString(R.string.size_name), Toast.LENGTH_SHORT).show()
        }
    }

    private fun onClickCardCategory(category: String, cardBasicInformation: Basic) {
        val bundle = Bundle()
        val intent = Intent(this, CardsActivity::class.java)
        intent.putExtra(CardsActivity.category_type, category)
        intent.putExtra(CardsActivity.card_basic_information, cardBasicInformation)

        startActivity(intent, bundle)
    }
}