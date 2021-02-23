package com.quartack.bdapter.sample.basic.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.basic.BasicViewModel
import com.quartack.bdapter.sample.databinding.ViewholderTextItemBinding

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderTextItemBinding::class,
    viewModelClass = BasicViewModel::class
)
data class TextItem(
    val id: Int,
    val label: String
)
