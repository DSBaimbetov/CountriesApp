package com.example.mvvmexample.Network

/**
 * Класс репозитория инкапсулирует логику для доступа к данным из одного источника
 * или совокупности источников. Он определяет, как захватывать и хранить определенный набор данных
 * — локально, в базе данных или с удаленного сервера.
 */

class MainRepository(private val retrofitService: RetrofitService) {
    fun getAllCountries() = retrofitService.getAllCountries() //api
}
