package com.quartack.bdapter.sample.tree.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderLeafItemBinding
import com.quartack.bdapter.sample.tree.TreeViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderLeafItemBinding::class,
    viewModelClass = TreeViewModel::class
)
data class LeafItem(
    val id: Int
)
