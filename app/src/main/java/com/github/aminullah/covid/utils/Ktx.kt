package com.github.aminullah.covid.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

inline fun <reified T> AppCompatActivity.launchActivity(context: Context, isFinishedActivity: Boolean) {
    if(isFinishedActivity) {
        this.startActivity(Intent(context, T::class.java))
        this.finish()
    } else {
        this.startActivity(Intent(context, T::class.java))
    }
}