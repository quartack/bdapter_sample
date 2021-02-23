package com.quartack.bdapter.sample.grid

import com.quartack.bdapter.sample.R
import com.quartack.bdapter.sample.grid.model.GridItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object GridRepository {
    suspend fun getItems(): List<Any> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            listOf(
                GridItem(R.drawable.google),
                GridItem(R.drawable.facebook),
                GridItem(R.drawable.instagram),
                GridItem(R.drawable.google),
                GridItem(R.drawable.facebook),
                GridItem(R.drawable.instagram),
                GridItem(R.drawable.google),
                GridItem(R.drawable.facebook),
                GridItem(R.drawable.instagram),
                GridItem(R.drawable.google),
                GridItem(R.drawable.facebook),
                GridItem(R.drawable.instagram),
                GridItem(R.drawable.google),
                GridItem(R.drawable.facebook),
                GridItem(R.drawable.instagram)
            )
        }

        loadJob.await()
    }
}
