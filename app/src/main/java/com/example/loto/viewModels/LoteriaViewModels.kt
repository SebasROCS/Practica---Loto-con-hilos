package com.example.loto.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf //import para el mutableStateOf
import androidx.lifecycle.ViewModel//import para el ViewModel

class LoteriaViewModels: ViewModel() {
    private val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumbers: State<List<Int>> = _lotoNumbers

    fun generateLotoNumbers()
    {
        _lotoNumbers.value=(1 .. 60).shuffled().take(6).sorted() //genera una lista de seis numeros aleatorios de entre el 1 al 60 y se imprimen de manera ordenada segun su valor
    }
}


