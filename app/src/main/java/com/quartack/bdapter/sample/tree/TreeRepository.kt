package com.quartack.bdapter.sample.tree

import com.quartack.bdapter.sample.tree.model.InternalItem
import com.quartack.bdapter.sample.tree.model.LeafItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.util.concurrent.atomic.AtomicInteger

object TreeRepository {
    suspend fun getItems(): List<Any> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (1..3)
                .toList()
                .flatMap {
                    val leafItems = getLeafItems((it * 2))
                    listOf(InternalItem(it, leafItems)) + leafItems
                }
        }

        loadJob.await().toList()
    }

    private val idGenerator = AtomicInteger(0)
    private fun getLeafItems(size: Int) =
        (0..size)
            .toList()
            .map {
                LeafItem(idGenerator.incrementAndGet())
            }
}
