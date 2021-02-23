package com.quartack.bdapter.sample.drag

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.quartack.bdapter.sample.databinding.ActivityDragBinding

class DragActivity : AppCompatActivity() {
    private val viewModel by viewModels<DragViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initViewModel()
        initRecyclerView()
    }

    private fun initDataBinding() {
        binding = ActivityDragBinding.inflate(layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
            it.lifecycleOwner!!.lifecycle.addObserver(viewModel)
            setContentView(it.root)
        }
    }

    private fun initViewModel() {
        viewModel.fetchItems()
    }

    private fun initRecyclerView() {
        itemTouchHelper = ItemTouchHelper(onDragCallback)
        itemTouchHelper.attachToRecyclerView(binding.recycler)
    }

    private val onDragCallback = object : ItemTouchHelper.Callback() {
        override fun isItemViewSwipeEnabled() = false

        /**
         * If you want to drag when long-press,
         * change the value to true and remove the `binding:draggable` from the view-holder layout.
         */
        override fun isLongPressDragEnabled() = false

        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) =
            makeMovementFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            viewModel.onDragged(viewHolder.adapterPosition, target.adapterPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        }
    }
}

private lateinit var binding: ActivityDragBinding
private lateinit var itemTouchHelper: ItemTouchHelper

@SuppressLint("ClickableViewAccessibility")
@BindingAdapter("binding:draggable")
fun View.setDraggable(enable: Boolean) {
    setOnTouchListener { view, event ->
        if (enable && event.action == MotionEvent.ACTION_DOWN) {
            binding.recycler.findContainingViewHolder(view)?.let {
                itemTouchHelper.startDrag(it)
            }
        }
        true
    }
}
