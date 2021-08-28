package com.example.mysqlroomdb.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    //All database access will write in this file
    //CRUD

    @Insert
    fun insertProduct(p:Product)

    @Query("DELETE FROM product_table")
    fun clear()

    @Query("SELECT * FROM product_table")
    fun getAll() : List<Product>

    @Query("SELECT * FROM product_table WHERE price < :price") //:price = parameter
    fun getPriceLessThan(price : Double) : List<Product>
}