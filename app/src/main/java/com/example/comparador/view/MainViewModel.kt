package com.example.comparador.view

import androidx.lifecycle.ViewModel
import com.example.comparador.model.ComparisonResult

class MainViewModel : ViewModel() {

    //funcion para que se produzca la igualdad
    fun compararTextos(a: String, b: String): ComparisonResult {
        return ComparisonResult(a == b)
    }
}