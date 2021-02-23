package com.quartack.bdapter.sample.variable_name

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.quartack.bdapter.sample.databinding.ActivityVariableNameBinding

class VariableNameActivity : AppCompatActivity() {
    private val viewModel by viewModels<VariableNameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        ActivityVariableNameBinding.inflate(layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
            it.lifecycleOwner!!.lifecycle.addObserver(viewModel)
            setContentView(it.root)
        }
    }

    private fun initViewModel() {
        viewModel.fetchItems()
    }
}
