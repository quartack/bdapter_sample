package com.quartack.bdapter.sample.grid.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderGridItemBinding
import com.quartack.bdapter.sample.grid.GridViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderGridItemBinding::class,
    viewModelClass = GridViewModel::class
)
data class GridItem(
    val res: Int
)
