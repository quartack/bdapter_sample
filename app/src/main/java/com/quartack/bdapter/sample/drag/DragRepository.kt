package com.quartack.bdapter.sample.drag

import com.quartack.bdapter.sample.drag.model.DragItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object DragRepository {
    suspend fun getItems(): List<DragItem> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (0..10)
                .toList()
                .map {
                    DragItem(it)
                }
        }

        loadJob.await()
    }
}
