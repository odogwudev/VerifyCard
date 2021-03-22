package com.odogwudev.verifycard.app.util

import android.view.View
import android.view.View.VISIBLE

object Helpers {
    fun View.enableState(enable: Boolean) {
        if (enable) {
            alpha = 1F
            isEnabled = true
        } else {
            alpha = 0.5F
            isEnabled = false
        }
    }

    fun View.reveal() {
        this.visibility = VISIBLE
    }

    fun View.disapear() {
        this.visibility = VISIBLE
    }
}