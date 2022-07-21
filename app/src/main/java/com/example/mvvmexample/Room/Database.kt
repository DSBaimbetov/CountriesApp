package com.example.mvvmexample.Room

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Country::class)], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun CountryDao(): CountryDao

//    private lateinit var INSTANCE : com.example.mvvmexample.Room.Database
//
//    fun getDatabase(context: Context): com.example.mvvmexample.Room.Database {
//
//        synchronized(com.example.mvvmexample.Room.Database::class.java) {
//            if (!::INSTANCE.isInitialized) {
//                INSTANCE = Room.databaseBuilder(
//                    context.applicationContext,
//                    com.example.mvvmexample.Room.Database::class.java,
//                    "database"
//                ).build()
//            }
//        }
//        return INSTANCE
//    }
}


