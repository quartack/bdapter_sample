package com.quartack.bdapter.sample.tree

import android.app.Application
import androidx.lifecycle.*
import com.quartack.bdapter.sample.tree.model.InternalItem
import kotlinx.coroutines.launch

class TreeViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private val _items = MutableLiveData<List<Any>>().apply { value = emptyList() }
    val items: LiveData<List<Any>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = TreeRepository.getItems()
        }
    }

    val changedItemsPosition = MutableLiveData<List<Int>?>()
    fun onClick(item: InternalItem) {
        _items.value = _items.value?.toMutableList()?.apply {
            val index = indexOf(item)

            item.isOpen = !item.isOpen
            changedItemsPosition.value = listOf(index)

            if (item.isOpen) {
                addAll(index + 1, item.childItems)
            } else {
                removeAll(item.childItems)
            }
        } ?: return
    }
}
