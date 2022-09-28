package com.example.mvvmexample

//
//@Entity
//data class Country(
//    val capital: String,
//    val img: String,
//    val name: String,
//    val text: String
//)
//
//@Dao
//interface CountryDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertCountry(country: Country)
//
//    @get:Query("select * from Country")
//    val countryLiveData: LiveData<Country>
//}
//
//@Database(entities = [Country::class], version = 1, exportSchema = false)
//abstract class CountryDatabase : RoomDatabase() {
//    abstract val countryDao : CountryDao
//}
//
//private lateinit var INSTANCE : CountryDatabase
//
//fun getDatabase(context: Context): CountryDatabase {
//    synchronized(CountryDatabase::class) {
//        if (!::INSTANCE.isInitialized) {
//            INSTANCE = Room
//                .databaseBuilder(
//                    context.applicationContext,
//                    CountryDatabase::class.java,
//                    "countries_db"
//                )
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//    }
//    return INSTANCE
//}