package com.hamzaaktay.dogappmvvm.api

import com.hamzaaktay.dogappmvvm.model.ApiModel
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("api/breeds/image/random")
    suspend fun getRandomDog(): Response<ApiModel>
}