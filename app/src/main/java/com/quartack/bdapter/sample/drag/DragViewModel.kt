package com.quartack.bdapter.sample.drag

import android.app.Application
import androidx.lifecycle.*
import com.quartack.bdapter.sample.drag.model.DragItem
import kotlinx.coroutines.launch


class DragViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private val _items = MutableLiveData<List<DragItem>>().apply { value = emptyList() }
    val items: LiveData<List<DragItem>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = DragRepository.getItems()
        }
    }

    fun onDragged(from: Int, to: Int) {
        val list = _items.value?.toMutableList() ?: return
        val item: DragItem = list[from]
        list.removeAt(from)
        list.add(to, item)
        _items.value = list
    }
}
