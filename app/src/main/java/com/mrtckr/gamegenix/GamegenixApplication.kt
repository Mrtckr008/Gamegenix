package com.mrtckr.gamegenix

import android.app.Application
import com.huawei.hms.ads.HwAds
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GamegenixApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        HwAds.init(this)
    }
}