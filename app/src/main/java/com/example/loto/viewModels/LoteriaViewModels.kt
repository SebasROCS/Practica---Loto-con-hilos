package com.example.loto.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf //import para el mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel//import para el ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class LoteriaViewModels: ViewModel() {
    var indiceNum = 1

    private val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumbers: State<List<Int>> = _lotoNumbers

    var isLoading by mutableStateOf(false)
     private set

    fun fetchData () {
        viewModelScope.launch {
            try {
                isLoading = true
                generarLista()
            } catch ( e:Exception ) {
                println ( "Error: ${e.message}" )
            } finally {
                isLoading = false
            }
        }
    }

    private suspend fun generarLista(){
        val controlDeNums = mutableListOf<Int>()
        for (i in 1..6){
            val num = (1..60).shuffled().first()
            controlDeNums.add(num)
            _lotoNumbers.value = controlDeNums.toList().sorted()
            delay(2000)
            indiceNum++
        }
        indiceNum++
    }


}


