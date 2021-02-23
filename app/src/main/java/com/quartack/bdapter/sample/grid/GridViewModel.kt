package com.quartack.bdapter.sample.grid

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class GridViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private val _items = MutableLiveData<List<Any>>().apply { value = emptyList() }
    val items: LiveData<List<Any>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = GridRepository.getItems()
        }
    }
}
