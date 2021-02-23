package com.quartack.bdapter.sample.recycler_inside_recycler

import com.quartack.bdapter.sample.R
import com.quartack.bdapter.sample.recycler_inside_recycler.model.HorizontalItem
import com.quartack.bdapter.sample.recycler_inside_recycler.model.VerticalItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object RIRRepository {
    suspend fun getItems(): List<Any> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (0..20)
                .toList()
                .map {
                    if (it == 10) {
                        HorizontalItem(
                            it,
                            listOf(
                                HorizontalItem.ChildItem(R.drawable.google),
                                HorizontalItem.ChildItem(R.drawable.facebook),
                                HorizontalItem.ChildItem(R.drawable.instagram),
                                HorizontalItem.ChildItem(R.drawable.google),
                                HorizontalItem.ChildItem(R.drawable.facebook),
                                HorizontalItem.ChildItem(R.drawable.instagram),
                                HorizontalItem.ChildItem(R.drawable.google),
                                HorizontalItem.ChildItem(R.drawable.facebook),
                                HorizontalItem.ChildItem(R.drawable.instagram)
                            )
                        )
                    } else {
                        VerticalItem(it)
                    }
                }
        }

        loadJob.await()
    }
}
