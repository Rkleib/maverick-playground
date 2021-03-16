package com.rkleib.maverickplayground

import android.app.Application
import com.airbnb.mvrx.Mavericks


class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}