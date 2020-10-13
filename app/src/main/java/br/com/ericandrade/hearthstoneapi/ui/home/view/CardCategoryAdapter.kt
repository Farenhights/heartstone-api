package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import kotlinx.android.synthetic.main.item_card.view.*
import kotlinx.android.synthetic.main.item_card_category_title.view.*

class CardCategoryAdapter(
    private val cardCategories: ArrayList<Pair<Int, CardCategory>>,
    private val onClick: (CardCategory) -> Unit
) : RecyclerView.Adapter<CardCategoryAdapter.ViewHolder>() {

    companion object {
        val HEADER = 0
        val CHILD = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    Log.d("VIEW TYPE", viewType.toString())
        val view = when (viewType) {
            HEADER -> {
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
        setupCardCategory(view, item.second)
    }

    private fun setupCardCategory(
        view: View,
        item: CardCategory
    ) {
        view.cardCategoryRecyclerView.adapter = CardAdapter(item.cardsByType, onClick)
    }
}