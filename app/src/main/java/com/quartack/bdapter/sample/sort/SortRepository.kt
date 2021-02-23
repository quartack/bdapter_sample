package com.quartack.bdapter.sample.sort

import com.quartack.bdapter.sample.sort.model.SortItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object SortRepository {
    suspend fun getItems(): List<SortItem> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (0..10)
                .toList()
                .map {
                    SortItem(it)
                }
        }

        loadJob.await()
    }
}
