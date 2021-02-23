package com.quartack.bdapter.sample.update.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderButtonItemBinding
import com.quartack.bdapter.sample.update.UpdateViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderButtonItemBinding::class,
    viewModelClass = UpdateViewModel::class
)
data class ButtonItem(
    val id: Int,
    val type: Type
) {
    enum class Type {
        ADD, REMOVE, UP, DOWN, RESET
    }
}
