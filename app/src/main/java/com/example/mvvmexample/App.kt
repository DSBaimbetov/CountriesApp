package com.example.mvvmexample

import android.app.Application
import com.example.mvvmexample.di.Module.appModule
import com.example.mvvmexample.di.Module.repoModule
import com.example.mvvmexample.di.Module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


//Позволяет настроить ведение журнала, загрузки свойств и модулей.
//конфигурация экземпляра контейнера Koin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.INFO)
            androidContext(this@App)
            //список модулей Koin для загрузки в контейнер
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}