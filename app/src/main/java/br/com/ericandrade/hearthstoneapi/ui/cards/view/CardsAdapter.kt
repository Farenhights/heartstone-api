package br.com.ericandrade.hearthstoneapi.ui.cards.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.domain.general.CardType
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_card.view.*

class CardsAdapter(
    private val cardCategories: List<CardType>
) : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardType = cardCategories[position]
        if (cardType.img.isEmpty()) {
            holder.cardImage.setImageResource(R.drawable.ic_broken_image)
        } else {
            Picasso.get()
                .load(cardType.img.replace("http", "https"))
                .error(R.drawable.ic_broken_image)
                .into(holder.cardImage)
        }
    }

    override fun getItemCount(): Int {
        return cardCategories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardImage = view.cardImageView!!
    }
}