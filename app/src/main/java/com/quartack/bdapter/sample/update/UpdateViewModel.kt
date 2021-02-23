package com.quartack.bdapter.sample.update

import android.app.Application
import androidx.lifecycle.*
import com.quartack.bdapter.sample.update.model.ButtonItem
import com.quartack.bdapter.sample.update.model.CompoundButtonItem
import kotlinx.coroutines.launch

class UpdateViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {
    private val _items = MutableLiveData<List<Any>>().apply { value = emptyList() }
    val items: LiveData<List<Any>>
        get() = _items

    fun fetchItems(isAppend: Boolean = false) {
        viewModelScope.launch {
            val oldItems =
                if (isAppend) _items.value
                else null

            _items.value = (oldItems ?: emptyList()) + UpdateRepository.getItems()
        }
    }

    fun onButtonClick(item: ButtonItem) {
        when (item.type) {
            ButtonItem.Type.ADD -> {
                fetchItems(true)
            }
            ButtonItem.Type.REMOVE -> {
                _items.value = _items.value?.toMutableList()?.apply {
                    remove(item)
                } ?: return
            }
            ButtonItem.Type.UP -> {
                _items.value = _items.value?.toMutableList()?.apply {
                    val oldIndex = indexOf(item)
                    remove(item)
                    add(oldIndex - 1, item)
                } ?: return
            }
            ButtonItem.Type.DOWN -> {
                _items.value = _items.value?.toMutableList()?.apply {
                    val oldIndex = indexOf(item)
                    remove(item)
                    add(oldIndex + 1, item)
                } ?: return
            }
            ButtonItem.Type.RESET -> {
                fetchItems(false)
            }
        }
    }

    val changedItemsPosition = MutableLiveData<List<Int>?>()
    fun onSelectChanged(item: CompoundButtonItem) {
        val list = _items.value ?: return
        val index = list.indexOf(item)
        changedItemsPosition.value = listOf(index)
    }
}
