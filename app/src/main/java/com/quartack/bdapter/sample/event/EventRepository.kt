package com.quartack.bdapter.sample.event

import com.quartack.bdapter.sample.event.model.EventItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object EventRepository {
    suspend fun getItems(): List<Any> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (0..20)
                .toList()
                .map {
                    EventItem(it)
                }
        }

        loadJob.await()
    }
}
