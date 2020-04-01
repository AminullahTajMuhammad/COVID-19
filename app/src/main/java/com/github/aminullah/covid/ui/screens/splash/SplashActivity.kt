package com.github.aminullah.covid.ui.screens.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.github.aminullah.covid.R
import com.github.aminullah.covid.ui.screens.dash_board.DashboardActivity
import com.github.aminullah.covid.utils.launchActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            this.launchActivity<DashboardActivity>(context = this, isFinishedActivity = true)
        }, 3000)
    }
}
