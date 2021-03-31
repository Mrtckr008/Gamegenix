package com.mrtckr.gamegenix.di

import com.mrtckr.gamegenix.api.IRetrofit
import com.mrtckr.gamegenix.repo.GameRepository
import com.mrtckr.gamegenix.repo.IGameRepository
import com.mrtckr.gamegenix.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
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
    fun injectNormalRepo(api: IRetrofit) = GameRepository(api) as IGameRepository
}