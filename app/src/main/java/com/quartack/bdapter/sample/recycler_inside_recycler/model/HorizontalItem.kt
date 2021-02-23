package com.quartack.bdapter.sample.recycler_inside_recycler.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.recycler_inside_recycler.RIRViewModel
import com.quartack.bdapter.sample.databinding.ViewholderHorizontalChildItemBinding
import com.quartack.bdapter.sample.databinding.ViewholderHorizontalItemBinding

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderHorizontalItemBinding::class,
    viewModelClass = RIRViewModel::class
)
data class HorizontalItem(
    val id: Int,
    val children: List<ChildItem>
) {
    @Keep
    @BdapterViewHolder(
        dataBinding = ViewholderHorizontalChildItemBinding::class,
        viewModelClass = RIRViewModel::class
    )
    data class ChildItem(
        val res: Int
    )
}
