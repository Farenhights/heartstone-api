package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import kotlinx.android.synthetic.main.item_card.view.*
import kotlinx.android.synthetic.main.item_card_category_title.view.*

class CardCategoryAdapter(
    private val cardCategories: ArrayList<Pair<Int, CardCategory>>,
    private val onClick: (CardType) -> Unit
) : RecyclerView.Adapter<CardCategoryAdapter.ViewHolder>() {

    companion object {
        const val HEADER_TITLE = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = when (viewType) {
            HEADER_TITLE -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_category_title, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card, parent, false)
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardType = cardCategories[position]
        if (cardType.first == HEADER_TITLE) {
            bindTitleGroup(holder.itemView, position)
        } else {
            bindCardGroup(holder.itemView, position)
        }
    }

    private fun bindTitleGroup(view: View, position: Int) {
        val item = cardCategories[position]
        view.cardCategoryTitleTextView.text = item.second.title
    }

    private fun bindCardGroup(view: View, position: Int) {
        val item = cardCategories[position]
        setupCardAdapter(view, item.second)
    }

    private fun setupCardAdapter(
        view: View,
        item: CardCategory
    ) {
        view.cardCategoryRecyclerView.adapter = CardAdapter(item.cardTypes, onClick)
    }

    override fun getItemViewType(position: Int): Int {
        return cardCategories[position].first
    }

    override fun getItemCount(): Int {
        return cardCategories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}