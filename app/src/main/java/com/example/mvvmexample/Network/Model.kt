package com.example.mvvmexample.Network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model(
    val capital: String,
    val img: String,
    val name: String,
    val text: String
    ) : Parcelable
//{
//    val description: String
//    get() = "$name is $capital"
//}