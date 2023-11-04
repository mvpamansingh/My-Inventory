package com.example.myinventory

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*

class ProductRepository(private val productDao: ProductDao) {
   val searchResults = MutableLiveData<List<Product>>()
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
        coroutineScope.async(Dispatchers.IO) {
            return@async productDao.findProduct(name)
        }
}