package br.com.ericandrade.hearthstoneapi.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import br.com.ericandrade.hearthstoneapi.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cardCategories = mutableListOf(
            CardCategory("Druid"),
            CardCategory("Human"),
            CardCategory("Vampyr")
        )

        cardCategoryRecyclerView.adapter = CardCategoryAdapter(
            cardCategories,
            ::onClickCardCategory
        )
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