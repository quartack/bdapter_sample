package com.quartack.bdapter.sample.filter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.quartack.bdapter.sample.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {
    private val viewModel by viewModels<FilterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        ActivityFilterBinding.inflate(layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
            it.lifecycleOwner!!.lifecycle.addObserver(viewModel)
            setContentView(it.root)
        }
    }

    private fun initViewModel() {
        viewModel.fetchItems()
        viewModel.condition.observe(this, {
            // nothing to do
        })
    }
}
