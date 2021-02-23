package com.quartack.bdapter.sample.tree.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderInternalItemBinding
import com.quartack.bdapter.sample.tree.TreeViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderInternalItemBinding::class,
    viewModelClass = TreeViewModel::class
)
data class InternalItem(
    val id: Int,
    val childItems: List<LeafItem>,
    var isOpen: Boolean = true
)
