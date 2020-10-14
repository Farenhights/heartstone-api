package br.com.ericandrade.hearthstoneapi.ui.cards.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import androidx.lifecycle.Observer
import br.com.ericandrade.hearthstoneapi.databinding.ActivityCardsBinding
import br.com.ericandrade.hearthstoneapi.ui.base.BaseActivity
import br.com.ericandrade.hearthstoneapi.ui.cards.viewModel.CardsViewModel
import org.koin.android.ext.android.inject

class CardsActivity : BaseActivity() {

    private val viewModel: CardsViewModel by inject()

    companion object {
        const val player_class = "playerClass"
        const val category_type = "categoryType"
    }

    private val playerClass: String by lazy {
        intent.extras?.getSerializable(player_class) as String
    }

    private val categoryType: String by lazy {
        intent.extras?.getSerializable(category_type) as String
    }

    private val binding: ActivityCardsBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_cards
        ) as ActivityCardsBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        setBinding()
        setObservables()
        setView()
        setEvents()
    }

    private fun setBinding() {
        binding.viewModel = viewModel
    }

    private fun setObservables() {
        binding.viewModel!!.loadingLiveData.observe(this@CardsActivity, Observer { shouldShow ->
            showIndeterminateProgressDialog(R.string.wait, shouldShow)
        })

        binding.viewModel!!.cardsLiveData.observe(
            this,
            Observer { cardTypeList ->
                binding.cardsRecyclerView.adapter = CardsAdapter(cardTypeList)
            }
        )
    }

    private fun setView() {
        binding.viewModel!!.setTitle(categoryType)
        binding.viewModel!!.getCardsByType(playerClass)
    }

    private fun setEvents() {

    }
}