package com.quartack.bdapter.sample.filter.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderUserItemBinding
import com.quartack.bdapter.sample.filter.FilterViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderUserItemBinding::class,
    viewModelClass = FilterViewModel::class
)
data class UserItem(
    val id: Int,
    val gender: Gender
) {
    enum class Gender {
        MALE, FEMALE, UNKNOWN
    }
}
