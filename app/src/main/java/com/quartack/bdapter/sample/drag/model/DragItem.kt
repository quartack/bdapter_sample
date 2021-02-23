package com.quartack.bdapter.sample.drag.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderDragItemBinding
import com.quartack.bdapter.sample.drag.DragViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderDragItemBinding::class,
    viewModelClass = DragViewModel::class
)
data class DragItem(
    val id: Int
)
