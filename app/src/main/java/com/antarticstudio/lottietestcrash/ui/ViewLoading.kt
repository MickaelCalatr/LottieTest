package com.antarticstudio.lottietestcrash.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.antarticstudio.lottietestcrash.R

fun View.displayLoading(display: Boolean) {
    val loader = this.findViewById<View>(R.id.loadingLayout)
    val lottie = this.findViewById<LottieAnimationView>(R.id.lottieLoader)

    if (loader == null || lottie == null) {
        return
    }

    loader.setOnClickListener {
        //avoid click behind
    }

    if (display) {
        loader.animateVisible()
        lottie.repeatCount = 0
        lottie.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                lottie.repeatCount = LottieDrawable.INFINITE
                lottie.playAnimation()
            }
        })
        lottie.playAnimation()
    } else {
        loader.animateInvisible()
    }
}

fun View.animateVisible(animationDuration: Long = 300) {
    this.animate().setDuration(animationDuration)
        .alpha(1f)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                visibility = View.VISIBLE
            }
        })
}

fun View.animateInvisible(animationDuration: Long = 300) {
    this.animate().setDuration(animationDuration)
        .alpha(0f)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                visibility = View.GONE
            }
        })
}

