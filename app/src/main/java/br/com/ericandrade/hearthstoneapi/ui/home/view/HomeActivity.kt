package br.com.ericandrade.hearthstoneapi.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.databinding.ActivityHomeBinding
import br.com.ericandrade.hearthstoneapi.domain.general.CardByType
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import br.com.ericandrade.hearthstoneapi.ui.home.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject

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
//        binding.viewModel.cardsByTypeListLiveData.observe(
//            this, Observer(list ->
//            )
//        )
    }

    private fun setView() {
        val cardClasses = mutableListOf(
            CardCategory("Classes", listOf(CardByType(playerClass = "Priest"), CardByType(playerClass = "Druid"), CardByType(playerClass = "Zombie"))),
            CardCategory("Types", listOf(CardByType(playerClass = "Human"), CardByType(playerClass = "Priest"), CardByType(playerClass = "Vampire"), CardByType(playerClass = "Human"))),
            CardCategory("Races", listOf(CardByType(playerClass = "Vampire"), CardByType(playerClass = "Werewolf"), CardByType(playerClass = "Human"), CardByType(playerClass = "Druid"), CardByType(playerClass = "Werewolf")))
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

    private fun setEvents() {
        titleToolbarTextView.setOnClickListener {
            Toast.makeText(this, getString(R.string.size_name), Toast.LENGTH_SHORT).show()
        }
    }

    private fun onClickCardCategory(cardCategory: CardCategory) {
        Toast.makeText(this, cardCategory.title, Toast.LENGTH_SHORT).show()
    }
}