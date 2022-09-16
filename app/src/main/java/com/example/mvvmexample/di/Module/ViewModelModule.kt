package com.example.mvvmexample.di.Module

import com.example.mvvmexample.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule  = module {
    viewModelOf(::MainViewModel)
}