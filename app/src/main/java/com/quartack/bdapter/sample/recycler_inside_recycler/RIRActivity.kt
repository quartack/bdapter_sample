package com.quartack.bdapter.sample.recycler_inside_recycler

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.quartack.bdapter.sample.databinding.ActivityRIRBinding

class RIRActivity : AppCompatActivity() {
    private val viewModel by viewModels<RIRViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        ActivityRIRBinding.inflate(layoutInflater).also {
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
