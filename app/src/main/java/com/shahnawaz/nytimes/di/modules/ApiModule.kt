package com.shahnawaz.nytimes.di.modules

import com.shahnawaz.nytimes.model.MostViewedApi
import com.shahnawaz.nytimes.model.MostViewedService
import dagger.Module
import dagger.Provides

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private  val BASE_URL  = "http://api.nytimes.com"
    @Provides
    fun provideCountriesApi(): MostViewedApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MostViewedApi::class.java)
    }

    @Provides
    fun provideCountriesService(): MostViewedService {
        return MostViewedService()
    }

}