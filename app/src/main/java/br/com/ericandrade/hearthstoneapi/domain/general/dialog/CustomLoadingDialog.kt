package br.com.ericandrade.hearthstoneapi.domain.general.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import br.com.ericandrade.hearthstoneapi.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.loading_dialog.view.*

class CustomLoadingDialog(
    private val context: Context
) {
    var message: String = String()
    var messageRes: Int = 0

    private val messageLabel: String = "Aguarde..."
        get() {
            return when {
                message.isEmpty().not() -> message
                messageRes != 0 -> context.getString(messageRes)
                else -> field
            }
        }

    private fun getView(): View {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return layoutInflater.inflate(R.layout.loading_dialog, null).apply {
            label.text = messageLabel
        } ?: View(context)
    }

    private fun buildDialog(): AlertDialog = MaterialAlertDialogBuilder(context)
        .setView(getView())
        .setCancelable(false)
        .create()

    fun show() = buildDialog().apply { show() }
}