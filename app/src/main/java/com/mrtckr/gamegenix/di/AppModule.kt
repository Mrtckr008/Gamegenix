package com.mrtckr.gamegenix.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mrtckr.gamegenix.R
import com.mrtckr.gamegenix.api.IRetrofit
import com.mrtckr.gamegenix.repo.GameRepository
import com.mrtckr.gamegenix.repo.GenreRepository
import com.mrtckr.gamegenix.repo.IGameRepository
import com.mrtckr.gamegenix.repo.IGenreRepository
import com.mrtckr.gamegenix.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun injectRetrofit(): IRetrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(IRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun injectGameRepo(api: IRetrofit) = GameRepository(api) as IGameRepository

    @Singleton
    @Provides
    fun injectGenreRepo(api: IRetrofit) = GenreRepository(api) as IGenreRepository

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide
        .with(context).setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
        )
}