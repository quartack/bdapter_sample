package com.quartack.bdapter.sample.basic

import com.quartack.bdapter.sample.R
import com.quartack.bdapter.sample.basic.model.ImageItem
import com.quartack.bdapter.sample.basic.model.TextItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

object BasicRepository {
    suspend fun getItems(): List<Any> = coroutineScope {
        val testItemJob = async(Dispatchers.IO) {
            getTextItems()
        }
        val imageItemJob = async(Dispatchers.IO) {
            getImageItems()
        }

        awaitAll(testItemJob, imageItemJob).flatten()
    }

    private fun getTextItems() = listOf(
        TextItem(1, "bdatper"),
        TextItem(2, "support"),
        TextItem(3, "multiple"),
        TextItem(4, "viewHolder")
    )

    private fun getImageItems() = listOf(
        ImageItem("google", R.drawable.google),
        ImageItem("facebook", R.drawable.facebook),
        ImageItem("instagram", R.drawable.instagram)
    )
}
