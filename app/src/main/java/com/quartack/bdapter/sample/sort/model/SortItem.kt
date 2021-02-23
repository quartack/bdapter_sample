package com.quartack.bdapter.sample.sort.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderSortItemBinding
import com.quartack.bdapter.sample.sort.SortViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderSortItemBinding::class,
    viewModelClass = SortViewModel::class
)
data class SortItem(
    val id: Int
)
