package com.example.mysqlroomdb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Something like constructor
@Entity(tableName = "product_table")
data class Product (

    @PrimaryKey(autoGenerate = true)
    var id : Int,

    //@ColumnInfo (name="Desc") // name the column in database differently
    @ColumnInfo
    var name : String,

    @ColumnInfo
    var price : Double
)
