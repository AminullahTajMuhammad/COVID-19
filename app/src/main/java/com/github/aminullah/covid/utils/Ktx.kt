package com.github.aminullah.covid.utils

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.aminullah.covid.network.CovidApi
import com.github.aminullah.covid.network.NetController

inline fun <reified T> AppCompatActivity.launchActivity(context: Context, isFinishedActivity: Boolean) {
    if(isFinishedActivity) {
        this.startActivity(Intent(context, T::class.java))
        this.finish()
    } else {
        this.startActivity(Intent(context, T::class.java))
    }
}

fun AppCompatActivity.launchActivityWithData(intent: Intent, isFinishedActivity: Boolean) {
    if(isFinishedActivity) {
        this.startActivity(intent)
        this.finish()
    } else {
        this.startActivity(intent)
    }
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Any.getCovidApi(): CovidApi? {
    return NetController.getRetrofit()?.create(CovidApi::class.java)
}

fun AppCompatActivity.toolbarTitle(title: String) {
    this.supportActionBar?.title = title
}