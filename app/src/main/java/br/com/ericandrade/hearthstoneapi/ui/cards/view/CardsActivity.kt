package br.com.ericandrade.hearthstoneapi.ui.cards.view

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import br.com.ericandrade.hearthstoneapi.R
import androidx.lifecycle.Observer
import br.com.ericandrade.hearthstoneapi.databinding.ActivityCardsBinding
import br.com.ericandrade.hearthstoneapi.domain.general.Basic
import br.com.ericandrade.hearthstoneapi.ui.base.BaseActivity
import br.com.ericandrade.hearthstoneapi.ui.cards.viewModel.CardsViewModel
import org.koin.android.ext.android.inject

class CardsActivity : BaseActivity() {

    private val viewModel: CardsViewModel by inject()

    companion object {
        const val category_type = "categoryType"
        const val card_basic_information = "cardBasicInformation"
    }

    private val categoryType: String by lazy {
        intent.extras?.getSerializable(category_type) as String
    }

    private val cardBasicInformation: Basic by lazy {
        intent.extras?.getSerializable(card_basic_information) as Basic
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
        buildToolbar()
        loadCards()
    }

    private fun buildToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun loadCards() {
        when (categoryType) {
            getString(R.string.classes) -> binding.viewModel!!.getCardsByClass(cardBasicInformation.playerClass)
            getString(R.string.types) -> binding.viewModel!!.getCardsByType(cardBasicInformation.type)
            getString(R.string.races) -> binding.viewModel!!.getCardsByRace(cardBasicInformation.race)
            getString(R.string.qualities) -> binding.viewModel!!.getCardsByQuality(cardBasicInformation.rarity)
            getString(R.string.factions) -> binding.viewModel!!.getCardsByFaction(cardBasicInformation.faction)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}