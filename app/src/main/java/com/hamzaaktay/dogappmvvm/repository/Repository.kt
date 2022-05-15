package com.hamzaaktay.dogappmvvm.repository

import com.hamzaaktay.dogappmvvm.api.RetrofitInstance
import com.hamzaaktay.dogappmvvm.model.ApiModel
import retrofit2.Response

class Repository {

    suspend fun getRandomDogImage() : Response<ApiModel> {
        return RetrofitInstance.api.getRandomDog()
    }
}