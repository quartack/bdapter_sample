package com.quartack.bdapter.sample.filter

import android.app.Application
import androidx.lifecycle.*
import com.quartack.bdapter.sample.filter.model.UserItem
import com.quartack.bdapter.sample.sort.SortRepository
import com.quartack.bdapter.sample.sort.model.SortItem
import kotlinx.coroutines.launch

class FilterViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private lateinit var originalItems: List<UserItem>
    private val _items = MutableLiveData<List<UserItem>>().apply { value = emptyList() }
    val items: LiveData<List<UserItem>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            originalItems = FilterRepository.getItems()
            _items.value = originalItems
        }
    }

    private val onConditionChanged = Observer<Boolean> {
        if (!::originalItems.isInitialized) return@Observer

        _items.value = originalItems.filter {
            when (it.gender) {
                UserItem.Gender.MALE -> isMale.value ?: true
                UserItem.Gender.FEMALE -> isFemale.value ?: true
                UserItem.Gender.UNKNOWN -> isUnknown.value ?: true
            }
        }
    }

    val isMale = MutableLiveData<Boolean>().apply { value = true }
    val isFemale = MutableLiveData<Boolean>().apply { value = true }
    val isUnknown = MutableLiveData<Boolean>().apply { value = true }
    val condition = MediatorLiveData<Unit>().apply {
        addSource(isMale, onConditionChanged)
        addSource(isFemale, onConditionChanged)
        addSource(isUnknown, onConditionChanged)
    }
}
