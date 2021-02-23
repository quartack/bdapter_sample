package com.quartack.bdapter.sample.update

import com.quartack.bdapter.sample.update.model.ButtonItem
import com.quartack.bdapter.sample.update.model.CompoundButtonItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import java.util.concurrent.atomic.AtomicInteger

object UpdateRepository {
    private val idGenerator = AtomicInteger(0)

    suspend fun getItems(): List<Any> = coroutineScope {
        val buttonItemJob = async(Dispatchers.IO) {
            getButtonItems()
        }
        val compoundButtonItemJob = async(Dispatchers.IO) {
            getCompoundButtonItems()
        }

        awaitAll(buttonItemJob, compoundButtonItemJob).flatten()
    }

    private fun getButtonItems() = listOf(
        ButtonItem(idGenerator.incrementAndGet(), ButtonItem.Type.ADD),
        ButtonItem(idGenerator.incrementAndGet(), ButtonItem.Type.REMOVE),
        ButtonItem(idGenerator.incrementAndGet(), ButtonItem.Type.UP),
        ButtonItem(idGenerator.incrementAndGet(), ButtonItem.Type.DOWN),
        ButtonItem(idGenerator.incrementAndGet(), ButtonItem.Type.RESET)
    )

    private fun getCompoundButtonItems() = listOf(
        CompoundButtonItem(idGenerator.incrementAndGet(), true),
        CompoundButtonItem(idGenerator.incrementAndGet(), false)
    )
}
