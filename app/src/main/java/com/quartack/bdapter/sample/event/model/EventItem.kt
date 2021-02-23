package com.quartack.bdapter.sample.event.model

import androidx.annotation.Keep
import com.quartack.bdapter.annotation.BdapterViewHolder
import com.quartack.bdapter.annotation.OnBdapterViewHolderEventListener
import com.quartack.bdapter.sample.databinding.ViewholderEventItemBinding
import com.quartack.bdapter.sample.event.EventViewModel

@Keep
@BdapterViewHolder(
    dataBinding = ViewholderEventItemBinding::class,
    viewModelClass = EventViewModel::class,
    eventListener = EventListener::class
)
data class EventItem(
    val id: Int
)

@Keep
class EventListener :
    OnBdapterViewHolderEventListener<EventItem, EventItemBdapterViewHolder, EventViewModel>() {
    override fun onBindViewHolder(
        item: EventItem,
        holder: EventItemBdapterViewHolder,
        viewModel: EventViewModel
    ) {
        viewModel.onEventListener("onBindViewHolder from ${holder.adapterPosition}")
    }

    override fun onViewAttachedToWindow(
        item: EventItem,
        holder: EventItemBdapterViewHolder,
        viewModel: EventViewModel
    ) {
        viewModel.onEventListener("onViewAttachedToWindow from ${holder.adapterPosition}")
    }

    override fun onViewDetachedFromWindow(
        holder: EventItemBdapterViewHolder,
        viewModel: EventViewModel
    ) {
        viewModel.onEventListener("onViewDetachedFromWindow from ${holder.adapterPosition}")
    }

    override fun onViewRecycled(holder: EventItemBdapterViewHolder) {
    }

    override fun onFailedToRecycleView(holder: EventItemBdapterViewHolder): Boolean {
        return false
    }
}
