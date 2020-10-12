package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardCategory
import kotlinx.android.synthetic.main.item_card_category.view.*
import java.util.*

class CardCategoryAdapter(
    private val cardCategories: MutableList<CardCategory>,
    private val onClick: (CardCategory) -> Unit
) : RecyclerView.Adapter<CardCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardType = cardCategories[position]
        holder.title.text = cardType.title

        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.cardCategoryCardView.setCardBackgroundColor(color)

        holder.view.setOnClickListener { onClick(cardType) }
    }

    override fun getItemCount(): Int {
        return cardCategories.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.cardCategoryTitle!!
        val cardCategoryCardView = view.cardCategoryCardView!!
    }
}