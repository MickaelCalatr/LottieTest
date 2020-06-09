package com.antarticstudio.lottietestcrash

import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    companion object {
        private const val LAUNCH_APP_DELAY = 4000L
        private const val STARTUP_DELAY = 300L
        private const val ANIM_ITEM_DURATION = 1000L
        private const val ITEM_DURATION = 500L
    }

    private val animationStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_SplashScreen)
        window.decorView.systemUiVisibility =
            SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        animationView.postDelayed({
            runApp()
        }, LAUNCH_APP_DELAY)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (!hasFocus || this.animationStarted) {
            return
        }
        animate()
        super.onWindowFocusChanged(hasFocus)
    }

    private fun animate() {
        ViewCompat.animate(animationView)
            .translationY(250f)
            .setStartDelay(STARTUP_DELAY)
            .setDuration(ANIM_ITEM_DURATION).setInterpolator(
                DecelerateInterpolator(1.2f)
            ).start()

        val viewAnimator = ViewCompat.animate(welcomeTextView)
            .translationY(-150f).alpha(1f)
            .setStartDelay(500).setDuration(ITEM_DURATION)

        viewAnimator.setInterpolator(DecelerateInterpolator()).start()
    }

    private fun runApp() {
        startActivity(MainActivity.newInstance(this))
        finish()
    }
}
