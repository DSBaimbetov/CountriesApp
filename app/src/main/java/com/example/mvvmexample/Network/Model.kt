package com.example.mvvmexample.Network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Model(
        val img:String,
        val name: String,
        val capital:String)
