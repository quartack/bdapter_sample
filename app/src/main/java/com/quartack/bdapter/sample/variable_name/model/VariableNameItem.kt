package com.quartack.bdapter.sample.variable_name.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.sample.databinding.ViewholderVariableNameItemBinding
import com.quartack.bdapter.sample.variable_name.VariableNameViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderVariableNameItemBinding::class,
    viewModelClass = VariableNameViewModel::class,
    viewModelVariableName = "name2",
    itemVariableName = "name1"
)
data class VariableNameItem(
    val id: Int
)
