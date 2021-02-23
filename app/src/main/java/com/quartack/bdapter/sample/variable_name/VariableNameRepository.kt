package com.quartack.bdapter.sample.variable_name

import com.quartack.bdapter.sample.variable_name.model.VariableNameItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object VariableNameRepository {
    suspend fun getItems(): List<Any> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (0..10)
                .toList()
                .map {
                    VariableNameItem(it)
                }
        }

        loadJob.await()
    }
}
