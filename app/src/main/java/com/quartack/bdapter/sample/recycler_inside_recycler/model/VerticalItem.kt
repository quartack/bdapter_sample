package com.quartack.bdapter.sample.recycler_inside_recycler.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.recycler_inside_recycler.RIRViewModel
import com.quartack.bdapter.sample.databinding.ViewholderVerticalItemBinding

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderVerticalItemBinding::class,
    viewModelClass = RIRViewModel::class
)
data class VerticalItem(
    val id: Int
)
