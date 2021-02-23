package com.quartack.bdapter.sample.update.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderCompoundButtonItemBinding
import com.quartack.bdapter.sample.update.UpdateViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderCompoundButtonItemBinding::class,
    viewModelClass = UpdateViewModel::class
)
data class CompoundButtonItem(
    val id: Int,
    var isSelected: Boolean = false,
)
