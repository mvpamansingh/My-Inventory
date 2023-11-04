package com.example.myinventory

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
// used livedata instead of Flow
@Dao
interface ProductDao {

    @Insert
    fun insertProduct(product: Product)

    @Query("select * from products where productName = :name")
    fun findProduct(name:String):List<Product>                     // no livedate attach to search product





    @Query("select * from products")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("delete from products where productName= :name ")
    fun deleteProduct(name: String)
}