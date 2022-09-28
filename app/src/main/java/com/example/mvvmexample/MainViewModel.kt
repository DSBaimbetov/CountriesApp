package com.example.mvvmexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.Network.MainRepository
import com.example.mvvmexample.Network.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

    //api
    val countryList = MutableLiveData<List<Model>>()
    val errorMessage = MutableLiveData<String>()

    init {
        getAllCountries()
    }

    //api
    fun getAllCountries() {
            val response = repository.getAllCountries()
            response.enqueue(object : Callback<List<Model>> {
                override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                    countryList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
    }
}