package com.example.counterappmvvm
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private var _repository = CounterRepository()
    private var _count  =  mutableStateOf(_repository.getCounter().count)

    var count  = _count

    fun increment(){
        _repository.increment()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrement()
        _count.value = _repository.getCounter().count
    }
}


