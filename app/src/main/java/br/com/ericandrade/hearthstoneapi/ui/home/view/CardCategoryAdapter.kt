package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import kotlinx.android.synthetic.main.item_card_category.view.*
import kotlinx.android.synthetic.main.item_card_category_title.view.*
import java.util.*
import kotlin.collections.ArrayList

class CardCategoryAdapter(
    private val cardCategories: ArrayList<Pair<Int, CardCategory>>,
    private val onClick: (CardCategory) -> Unit
) : RecyclerView.Adapter<CardCategoryAdapter.ViewHolder>() {

    companion object {
        val HEADER = 0
        val CHILD = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = when (viewType) {
            HEADER -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_category_title, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_category, parent, false)
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardType = cardCategories[position]
        if (cardType.first == HEADER) {
            bindItemGroup(holder.itemView, position)
        } else {
            bindItemChild(holder.itemView, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return cardCategories[position].first
    }

    override fun getItemCount(): Int {
        return cardCategories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private fun bindItemGroup(view: View, position: Int) {
        val item = cardCategories[position]
        view.cardCategoryTextView.text = item.second.title
    }

    private fun bindItemChild(view: View, position: Int) {
        val item = cardCategories[position]
        setupCardCategory(view, item)
    }

    private fun setupCardCategory(view: View, item: Pair<Int, CardCategory>) {
        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        view.cardCategoryCardView.setCardBackgroundColor(color)

        view.cardCategoryTitleTextView.text = item.second.cardByType.playerClass
    }
}