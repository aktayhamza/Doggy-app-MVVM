package com.hamzaaktay.dogappmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamzaaktay.dogappmvvm.model.ApiModel
import com.hamzaaktay.dogappmvvm.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class DogFragmentViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<ApiModel>> = MutableLiveData()

    fun getDogImage () {
        viewModelScope.launch {
            val response : Response<ApiModel> = repository.getRandomDogImage()
            if (response.isSuccessful) {
                myResponse.value = response
            }
        }
    }
}