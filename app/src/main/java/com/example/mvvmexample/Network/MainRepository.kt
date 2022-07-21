package com.example.mvvmexample.Network

import com.example.mvvmexample.Network.RetrofitService
import com.example.mvvmexample.Room.CountryDao
import com.example.mvvmexample.Room.Database

/**
 * Класс репозитория инкапсулирует логику для доступа к данным из одного источника
 * или совокупности источников. Он определяет, как захватывать и хранить определенный набор данных
 * — локально, в базе данных или с удаленного сервера.
 */
class MainRepository (
    private val retrofitService: RetrofitService
) {
    fun getAllCountries() = retrofitService.getAllCountries() //api
}
