package com.example.fruityvice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruityvice.model.Fruit
import com.example.fruityvice.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {
    private val _listFruits = MutableLiveData<List<Fruit>>()
    val listFruits: LiveData<List<Fruit>>
        get() = _listFruits

    fun getFruits() {
        viewModelScope.launch {
            _listFruits.value = repository.getFruits()
        }
    }
}