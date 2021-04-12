package com.mrtckr.gamegenix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.huawei.hms.ads.AdListener
import com.huawei.hms.ads.AdParam
import com.mrtckr.gamegenix.common.visible
import com.mrtckr.gamegenix.databinding.ActivityMainBinding
import com.mrtckr.gamegenix.ui.GamegenixFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var fragmentFactory: GamegenixFragmentFactory
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setActionBar(binding.toolbarLayout.toolbarLayout)
        binding.toolbarLayout.toolbarBackButton.setOnClickListener { onBackPressed() }

        actionBar?.setDisplayHomeAsUpEnabled(false)

        val navController = findNavController(R.id.navHostFragment)

        AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_genres
            )
        )
        binding.navView.setupWithNavController(navController)
        loadBannerAd()
    }

    private fun loadBannerAd(){
        binding.bannerView.adId = "testw6vs28auh3"
        binding.bannerView.setBannerRefresh(30)
        val adParam = AdParam.Builder().build()
        binding.bannerView.loadAd(adParam)

        val adListener: AdListener = object : AdListener() {
            override fun onAdLoaded() {
                binding.bannerView.visible()
            }
            override fun onAdOpened() {}
            override fun onAdClicked() {}
            override fun onAdLeave() {}
            override fun onAdClosed() {}
        }
        binding.bannerView.adListener = adListener
    }
}