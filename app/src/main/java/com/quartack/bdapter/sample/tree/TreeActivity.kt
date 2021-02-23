package com.quartack.bdapter.sample.tree

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.quartack.bdapter.sample.databinding.ActivityTreeBinding

class TreeActivity : AppCompatActivity() {
    private val viewModel by viewModels<TreeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        ActivityTreeBinding.inflate(layoutInflater).also {
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
