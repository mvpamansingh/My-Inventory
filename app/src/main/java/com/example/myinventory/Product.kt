package com.example.myinventory

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity(tableName = "products")
 class Product(
   @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "productId")
    var id:Int,




   @ColumnInfo(name= "productName")
    var  productName:String,



)
