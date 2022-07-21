package com.example.mvvmexample.Room

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "country_table")
data class Country (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "Img")
    val img:String,

    @ColumnInfo(name = "Name")
    val name: String,

    @ColumnInfo(name = "Capital")
    val capital:String
)

@Dao
interface CountryDao {
    @Query("SELECT * FROM country_table")
    fun getAllCountry(): Flow<List<Country>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(country: List<Country>)

    @Query("DELETE FROM COUNTRY_TABLE")
    suspend fun deleteAll()
}