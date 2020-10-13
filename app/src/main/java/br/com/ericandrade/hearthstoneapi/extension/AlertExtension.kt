package br.com.ericandrade.hearthstoneapi.extension

import android.content.Context
import br.com.ericandrade.hearthstoneapi.domain.general.dialog.CustomLoadingDialog

fun Context.loading(init: CustomLoadingDialog.() -> Unit): CustomLoadingDialog {
    return CustomLoadingDialog(this).apply { init() }
}