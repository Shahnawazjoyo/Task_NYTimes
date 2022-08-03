package com.shahnawaz.nytimes.model

import io.reactivex.Single
import retrofit2.http.GET

interface MostViewedApi {

//    @GET("DevTides/countries/master/countriesV2.json")
//    fun getCountries():Single<List<Country>>


    @GET("/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=GlIAg9LWk0AO3olNCqAWRtjVUHsfx25V")
    fun getMostViews():Single<MostViewed>




}