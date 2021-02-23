package com.quartack.bdapter.sample.event

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class EventViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private val _items = MutableLiveData<List<Any>>().apply { value = emptyList() }
    val items: LiveData<List<Any>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.value = EventRepository.getItems()
        }
    }

    private val _eventLog = MutableLiveData<String>().apply { value = "" }
    val eventLog: LiveData<String>
        get() = _eventLog

    fun onEventListener(event: String) {
        _eventLog.value = "$event\n${_eventLog.value ?: ""}"
    }
}
