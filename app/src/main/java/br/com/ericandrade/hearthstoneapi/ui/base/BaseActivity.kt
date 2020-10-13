package br.com.ericandrade.hearthstoneapi.ui.base

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.ericandrade.hearthstoneapi.R
import br.com.ericandrade.hearthstoneapi.extension.loading

open class BaseActivity: AppCompatActivity() {
    private lateinit var progressDialog: AlertDialog

     fun showIndeterminateProgressDialog(
        msgRes: Int = R.string.wait,
        shouldShow: Boolean = true
    ) {
        if (!this::progressDialog.isInitialized){
            if (!shouldShow){ return }
        } else {
            if (shouldShow.and(progressDialog.isShowing)){ return }
        }

        if (shouldShow) {
            progressDialog = loading { messageRes = msgRes }.show()
        } else {
            progressDialog.dismiss()
        }
    }
}