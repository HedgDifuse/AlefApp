package com.hedgdifuse.alefapp

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class AlefApp: Application() {

    override fun onCreate() {
        super.onCreate()

        // Init fresco
        Fresco.initialize(this)
    }
}