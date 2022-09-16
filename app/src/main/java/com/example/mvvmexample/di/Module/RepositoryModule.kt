package com.example.mvvmexample.di.Module

import com.example.mvvmexample.Network.MainRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repoModule = module {
    factoryOf(::MainRepository)
}