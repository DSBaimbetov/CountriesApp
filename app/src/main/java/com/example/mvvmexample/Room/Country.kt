package com.example.mvvmexample.Room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "country_table")
data class Country(
    @PrimaryKey

    @ColumnInfo(name = "Img")
    var img: String,

    @ColumnInfo(name = "Name")
    var name: String,

    @ColumnInfo(name = "Capital")
    var capital: String
)

@Dao
interface CountryDao {

    @Insert
    suspend fun insertCountries(country: Country): Long

    @Query("SELECT * FROM country_table")
    fun getAllCountry(): Flow<List<Country>>
}