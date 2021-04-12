package com.mrtckr.gamegenix.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.huawei.hms.ads.AdListener
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.InterstitialAd
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.common.BaseFragment
import com.mrtckr.gamegenix.databinding.FragmentDetailBinding
import com.mrtckr.gamegenix.model.gamedetail.GameDetail
import com.mrtckr.gamegenix.ui.detail.adapter.GamePlatformsAdapter
import com.mrtckr.gamegenix.ui.detail.adapter.GameStoresAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment(
    private val glide: RequestManager,
    private val platformRecyclerAdapter: GamePlatformsAdapter,
    private val storeGameRecyclerAdapter: GameStoresAdapter
) : BaseFragment<DetailViewModel, FragmentDetailBinding>() {
    override val layoutRes: Int = R.layout.fragment_detail
    override val viewModel: DetailViewModel by viewModels()

    var gameId = -1

    override fun observeViewModel() {
        viewModel.gameData.observe(viewLifecycleOwner, Observer { resultData ->
            resultData.toData()?.let { setupUI(it) }
            resultData.toData()?.platforms.let {
                if (it != null) {
                    platformRecyclerAdapter.platformList = it
                }
            }

            resultData.toData()?.stores.let {
                if (it != null) {
                    storeGameRecyclerAdapter.storeResult = it
                }
            }
            platformRecyclerAdapter.notifyDataSetChanged()
            storeGameRecyclerAdapter.notifyDataSetChanged()
        })
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        gameId = arguments?.get(this.requireContext().getString(R.string.game_id_bundle_name)) as Int
        viewModel.getGame(gameId)
        loadHMSInterstitialAd()
    }

    private fun setupUI(gameData: GameDetail) {
        glide.load(gameData.backgroundImage).into(binding.gameImage)

        binding.gameDescriptionText.text = gameData.descriptionRaw.toString()

        binding.gameName.text = gameData.nameOriginal.toString()

        gameData.metacritic?.let {
            binding.metaScoreValueText.text = it.toString()
        }


        if (gameData.publishers?.isNotEmpty()!!) {
            binding.publisherText.text = String.format(
                this.requireContext().getString(R.string.publisher_text),
                gameData.publishers?.get(0)?.name.toString()
            )
        }

        binding.toolbarBackButton.setOnClickListener {
            this.requireActivity().onBackPressed()
        }

        binding.gameReleasedText.text = String.format(
            this.requireContext().getString(R.string.released_date),
            gameData.released
        )
        binding.gameUpdatedText.text =
            String.format(this.requireContext().getString(R.string.updated_date), gameData.updated)
        binding.ratingScoreText.text =
            String.format(this.requireContext().getString(R.string.game_rating), gameData.rating)
        binding.metaScoreValueText.text = String.format(
            this.requireContext().getString(R.string.meta_score_value),
            gameData.metacritic
        )

        binding.gamePlatformsRecyclerView.adapter = platformRecyclerAdapter
        binding.gamePlatformsRecyclerView.layoutManager =
            LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.gameStoresRecyclerView.adapter = storeGameRecyclerAdapter
        binding.gameStoresRecyclerView.layoutManager =
            LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onResume() {
        super.onResume()
        setToolbarVisibility(View.GONE)
        setToolbarTitle(this.requireContext().getString(R.string.app_name))
        setToolbarBackButtonVisibility(View.GONE)
    }

    private fun loadHMSInterstitialAd(){
        val interstitialAd = InterstitialAd(this.requireContext())
        interstitialAd.adId = "testb4znbuh3n2"
        val adParam = AdParam.Builder().build()
        interstitialAd.loadAd(adParam)

        val adListener: AdListener = object : AdListener() {
            override fun onAdLoaded() {
                interstitialAd.show(this@DetailFragment.requireActivity())
            }
            override fun onAdFailed(errorCode: Int) {}
            override fun onAdClosed() {}
            override fun onAdClicked() {}
            override fun onAdLeave() {}
            override fun onAdOpened() {}
            override fun onAdImpression() {}
        }
        interstitialAd.adListener = adListener
    }
}