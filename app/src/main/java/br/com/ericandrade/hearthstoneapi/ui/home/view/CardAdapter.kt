package br.com.ericandrade.hearthstoneapi.ui.home.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardInformation
import kotlinx.android.synthetic.main.item_card_category.view.*
import java.util.*

class CardAdapter(
    private val cardInformation: CardInformation,
    private val onClick: (String, String) -> Unit
) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardBasic = cardInformation.cardBasicInformationList[position]
        val color: Int = setCardBackgroundRandomColor()

        holder.title.text = cardBasic.playerClass
        holder.cardView.setCardBackgroundColor(color)
        holder.cardView.setOnClickListener { onClick(cardInformation.category, cardBasic.playerClass) }
    }

    private fun setCardBackgroundRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    override fun getItemCount(): Int {
        return  cardInformation.cardBasicInformationList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.cardCategoryTitleTextView!!
        val cardView = view.cardCategoryCardView!!
    }
}