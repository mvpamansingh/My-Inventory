package com.example.myinventory

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application:Application): ViewModel() {

    val allProducts: LiveData<List<Product>>
    private val repository:ProductRepository
    val  searchResults: MutableLiveData<List<Product>>

    init {


        val productDb = ProductRoomDatabase.getInstance(application)
        val productDaoo = productDb.productDao()
        repository = ProductRepository(productDaoo)
        allProducts = repository.allProducts
        searchResults = repository.searchResults

    }

    suspend fun insertProduct(product:Product)
    {
        repository.insertProduct(product)
    }

    suspend fun findProduct(name: String)
    {
        repository.findProduct(name)
    }

    suspend fun deleteProduct(name:String)
    {
        repository.deleteProduct(name)
    }

}