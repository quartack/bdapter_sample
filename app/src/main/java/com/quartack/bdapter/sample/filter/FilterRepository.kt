package com.quartack.bdapter.sample.filter

import com.quartack.bdapter.sample.filter.model.UserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object FilterRepository {
    suspend fun getItems(): List<UserItem> = coroutineScope {
        val loadJob = async(Dispatchers.IO) {
            (0..20)
                .toList()
                .map {
                    UserItem(
                        it,
                        when {
                            it % 10 == 0 -> UserItem.Gender.UNKNOWN
                            it % 2 == 0 -> UserItem.Gender.MALE
                            else -> UserItem.Gender.FEMALE
                        }
                    )
                }
        }

        loadJob.await()
    }
}
