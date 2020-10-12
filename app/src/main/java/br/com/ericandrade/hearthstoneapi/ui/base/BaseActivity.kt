package br.com.ericandrade.hearthstoneapi.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

open class BaseActivity: AppCompatActivity() {

    open fun setStatusBarColor(context: Context, color: Int) {
        window.statusBarColor = ContextCompat.getColor(context, color)
    }
}