package com.example.mvvmexample

import android.opengl.Visibility
import android.widget.ProgressBar
import androidx.lifecycle.*
import com.example.mvvmexample.Network.MainRepository
import com.example.mvvmexample.Network.Model
import com.example.mvvmexample.Room.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    private val repository: MainRepository
    ) : ViewModel() {

    //api
    val countryList = MutableLiveData<List<Model>>()
    val errorMessage = MutableLiveData<String>()

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