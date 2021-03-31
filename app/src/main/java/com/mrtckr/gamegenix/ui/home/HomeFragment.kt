package com.mrtckr.gamegenix.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val layoutRes: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun observeViewModel() {

    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            viewModel.getGames()
        }
        viewModel.gameList.observe(viewLifecycleOwner, Observer {
            println(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}