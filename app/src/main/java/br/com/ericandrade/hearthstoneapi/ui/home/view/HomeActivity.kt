package br.com.ericandrade.hearthstoneapi.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardByType
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cardClasses = mutableListOf(
            CardCategory("Classes", CardByType(playerClass = "Priest")),
            CardCategory("Types", CardByType(playerClass = "Druid")),
            CardCategory("Races", CardByType(playerClass = "Druid")),
            CardCategory("Races", CardByType(playerClass = "Druid"))
        )

        val sortedList = cardClasses.groupBy { it.title }
        val listGroup = ArrayList<Pair<Int, CardCategory>>()

        for ((k, v) in sortedList) {
            listGroup.add(Pair(0, v.first()))
            v.forEach { cardCategory ->
                listGroup.add(Pair(1, cardCategory))
            }
        }

        cardCategoryRecyclerView.adapter = CardCategoryAdapter(
            listGroup,
            ::onClickCardCategory
        )

       /* cardTypesCategoryRecyclerView.adapter = CardCategoryAdapter(
            cardTypes,
            ::onClickCardCategory
        )

        cardRacesCategoryRecyclerView.adapter = CardCategoryAdapter(
            cardRaces,
            ::onClickCardCategory
        )*/

        titleToolbarTextView.setOnClickListener {
            Toast.makeText(this, getString(R.string.size_name), Toast.LENGTH_SHORT).show()
        }

        setView()
    }

    private fun setView() {

    }

    private fun onClickCardCategory(cardCategory: CardCategory) {
        Toast.makeText(this, cardCategory.title, Toast.LENGTH_SHORT).show()
    }
}