package com.example.myapplication.util


import android.os.SystemClock
import android.view.View

abstract class OnClickListenerImpedirDuplicados : View.OnClickListener {
    private var mLastClickTime: Long = 0

    override fun onClick(v: View) {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        if (elapsedTime <= MIN_CLICK_INTERVAL)
            return
        mLastClickTime = currentClickTime
        onClickImplementacao(v)
    }

    abstract fun onClickImplementacao(v: View)

    companion object {
        private val MIN_CLICK_INTERVAL: Long = 600
    }
}


