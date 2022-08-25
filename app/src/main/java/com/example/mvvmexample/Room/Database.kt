package com.example.mvvmexample.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Country::class)], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun CountryDao(): CountryDao

    companion object {
        @Volatile
        private var INSTANCE: com.example.mvvmexample.Room.Database? = null

        fun getDatabase(context: Context): com.example.mvvmexample.Room.Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.mvvmexample.Room.Database::class.java,
                    "database.db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}


