package com.quartack.bdapter.sample.basic.model

import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.basic.BasicViewModel
import com.quartack.bdapter.sample.databinding.ViewholderImageItemBinding

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderImageItemBinding::class,
    viewModelClass = BasicViewModel::class
)
data class ImageItem(
    val label: String,
    @DrawableRes val res: Int
)
