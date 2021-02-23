package com.quartack.bdapter.sample.sort

import android.app.Application
import androidx.lifecycle.*
import com.quartack.bdapter.sample.sort.model.SortItem
import kotlinx.coroutines.launch

class SortViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private val _items = MutableLiveData<List<SortItem>>().apply { value = emptyList() }
    val items: LiveData<List<SortItem>>
        get() = _items

    val isAscending = MutableLiveData<Boolean>().apply { value = true }

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = SortRepository.getItems()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        isAscending.observeForever(onChanged)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        isAscending.removeObserver(onChanged)
    }

    private val onChanged = Observer<Boolean> {
        val list = _items.value?.toMutableList() ?: return@Observer
        if (it) {
            list.sortBy { it.id }
        } else {
            list.sortByDescending { it.id }
        }
        _items.value = list
    }
}
