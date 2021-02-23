package com.quartack.bdapter.sample.grid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.quartack.bdapter.sample.databinding.ActivityGridBinding

class GridActivity : AppCompatActivity() {
    private val viewModel by viewModels<GridViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        ActivityGridBinding.inflate(layoutInflater).also {
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
