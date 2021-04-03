package com.mrtckr.gamegenix

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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
    }
}