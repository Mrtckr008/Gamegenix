package com.mrtckr.gamegenix.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.common.gone
import com.mrtckr.gamegenix.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {


    override fun onResume() {
        setToolbarVisibility(View.GONE)

        super.onResume()
    }

    override val layoutRes: Int = R.layout.fragment_splash
    override val viewModel: SplashViewModel by viewModels()

    override fun observeViewModel() {
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        val navBar: BottomNavigationView = this.requireActivity().findViewById(R.id.navView)
        navBar.gone()

        val extras = FragmentNavigatorExtras(
            binding.splashText to this.requireContext().getString(R.string.splash_transition_name)
        )
        Handler().postDelayed({
            findNavController().navigate(
                R.id.action_navigation_splash_to_homeFragment,null,null,extras
            )
        },1000)
    }
}