package com.example.calculadora

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val SUMA = "+"
    val RESTA = "-"
    val MULTIPLICACION = "*"
    val DIVISION = "/"
    val PORCENTAJE = "%"

    var operacionActual = ""

    var primerNumero: Double = Double.NaN
    var segundoNumero: Double = Double.NaN

    lateinit var TvTempo: TextView
    lateinit var tvResul: TextView

    lateinit var formatoDecimal: DecimalFormat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}