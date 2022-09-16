package com.example.mvvmexample.di.Module

import com.example.mvvmexample.Network.RetrofitService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * модуль - он создает модуль в Koin,
 * который будет использоваться Koin для предоставления всех зависимостей.
 */

val appModule = module {
    //Объявление одноэлементного компонента означает,
    // что контейнер Koin будет хранить уникальный экземпляр вашего объявленного компонента.
    single{RetrofitService}
}