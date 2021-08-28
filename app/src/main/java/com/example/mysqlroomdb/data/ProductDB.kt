package com.example.mysqlroomdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDB :RoomDatabase(){

    abstract val productDao: ProductDao

    companion object {

        @Volatile
        private var INSTANCE: ProductDB? = null // create one object

        fun getInstance(context: Context): ProductDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) { // if not such database found, create new one
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductDB::class.java,
                        "MyProduct_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance // if created, just use back
                }
                return instance
            }
        }
    }



}