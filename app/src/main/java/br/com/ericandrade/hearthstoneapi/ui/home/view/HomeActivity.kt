package br.com.ericandrade.hearthstoneapi.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.databinding.ActivityHomeBinding
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
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

                val cardClasses = mutableListOf(
                    CardCategory("Classes", card.basic),
                    CardCategory("Types", card.basic),
                    CardCategory("Races", card.basic)
                )

                val sortedList = cardClasses.groupBy { it.title }
                val listGroup = ArrayList<Pair<Int, CardCategory>>()

                for ((k, v) in sortedList) {
                    listGroup.add(Pair(0, v.first()))
                    v.forEach { cardCategory ->
                        listGroup.add(Pair(1, cardCategory))
                    }
                }

                binding.cardCategoryRecyclerView.adapter = CardCategoryAdapter(
                    listGroup,
                    ::onClickCardCategory
                )
            }
        )
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