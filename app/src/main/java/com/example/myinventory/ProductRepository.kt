package com.example.myinventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.async
class ProductRepository(private val productDao: ProductDao) {
   val searchResults = MutableLiveData<List<Product>>()
    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()
//
suspend fun insertProduct(newproduct: Product) {
        coroutineScope {
            productDao.insertProduct(newproduct)
        }
    }
    suspend fun deleteProduct(name: String) {
        coroutineScope{
            productDao.deleteProduct(name)
        }
    }
    suspend fun findProduct(name: String) {
        coroutineScope {
            searchResults.value = asyncFind(name).await()
        }
    }
    private suspend fun asyncFind(name: String): Deferred<List<Product>?> =
        coroutineScope {
             async {productDao.findProduct(name)  }


        }
}