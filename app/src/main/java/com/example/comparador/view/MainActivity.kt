package com.example.comparador.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.comparador.R
import com.example.comparador.databinding.ActivityMainBinding



class MainActivity : ComponentActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var mainViewModel: MainViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


            val boton = findViewById<Button>(R.id.button10)

            val resultadoTextView = findViewById<TextView>(R.id.textView_result_compare)

            //Click listener para el boton
            boton.setOnClickListener {
                val textoUno = findViewById<EditText>(R.id.editTextUno).text.toString()
                val textoDos = findViewById<EditText>(R.id.editTextDos).text.toString()

                //muestra o no, el texto segun los resultados para la funcion con sus parametros
                val comparisonResult = mainViewModel.compararTextos(textoUno,textoDos)

                //Si ambos parametros estan vacios, no muestra resultado
                if (textoUno.isEmpty() && textoDos.isEmpty()) {
                    resultadoTextView.visibility = View.GONE
                } else { //Si no estan vacios será visible
                    resultadoTextView.visibility = View.VISIBLE
                    if (comparisonResult.comparison) { //Si no son vacios y son iguales
                        resultadoTextView.setText(R.string.iguales)
                    } else { //Si no son vacios y no son iguales
                        resultadoTextView.setText(R.string.distintos)
                }
            }
        }
    }
}