package com.hyun.parkinghome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyun.parkinghome.db.CarDao
import com.hyun.parkinghome.db.CarEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(var dao: CarDao) : ViewModel() {
    private var TAG = javaClass.simpleName
    var selectAll: LiveData<List<CarEntity>> = MutableLiveData<List<CarEntity>>()
    fun insertCars(addr: String, number: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(CarEntity(addr = addr, number = number))
        }
    }

    fun selectAll() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.selectAll().onEach {
                Log.d(TAG, "${it.toString()}")
            }.launchIn(viewModelScope)
        }
    }
}