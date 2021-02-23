package com.quartack.bdapter.sample.basic

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BasicViewModel : ViewModel(), LifecycleObserver {
    private val _items = MutableLiveData<List<Any>>().apply { value = emptyList() }
    val items: LiveData<List<Any>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = BasicRepository.getItems()
        }
    }
}
