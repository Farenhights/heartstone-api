package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardByType
import kotlinx.android.synthetic.main.item_card_category.view.*
import java.util.*

class CardAdapter(
    private val cardCategories: List<CardByType>,
    private val onClick: (CardByType) -> Unit
) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardType = cardCategories[position]
        val color: Int = setCardBackgroundRandomColor()

        holder.title.text = cardType.playerClass
        holder.cardView.setCardBackgroundColor(color)
        holder.cardView.setOnClickListener { onClick(cardType) }
    }

    private fun setCardBackgroundRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    override fun getItemCount(): Int {
        return cardCategories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.cardCategoryTitleTextView!!
        val cardView = view.cardCategoryCardView!!
    }
}