package com.example.calculadora

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
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

        formatoDecimal = DecimalFormat("#.#######")
        TvTempo = findViewById(R.id.TvTempo)
        tvResul = findViewById(R.id.tvResul)
    }

    fun cambiarOperador(b: View) {
        calcular(b)
        val boton: Button = b as Button
        operacionActual = boton.text.toString().trim()
        tvResul.text = formatoDecimal.format(primerNumero) + operacionActual
        TvTempo.text =""
    }
    
    fun calcular(b: View) {
        if(primerNumero.toString()!="NaN"){
            segundoNumero = TvTempo.text.toString().toDouble()
            TvTempo.text=""

            when(operacionActual){
                "+" -> primerNumero = (primerNumero+segundoNumero)
                "-" -> primerNumero = (primerNumero-segundoNumero)
                "*" -> primerNumero = (primerNumero*segundoNumero)
                "/" -> primerNumero = (primerNumero/segundoNumero)
                "%" -> primerNumero = (primerNumero%segundoNumero)
            }
        }else{
             primerNumero = TvTempo.text.toString().toDouble()
        }
    }

    fun  seleccionarNumero(b: View){
        val boton: Button = b as Button
        if(TvTempo.text.toString()=="0"){
            TvTempo.text=""
        }
        TvTempo.text = TvTempo.text.toString() + boton.text.toString()
    }

    fun  igual(b: View){
        calcular(b)
        tvResul.text = formatoDecimal.format(primerNumero)
        //primerNumero = Double.NaN
        operacionActual = ""
    }

    fun borrar(b: View) {
        val boton: Button = b as Button
        if(boton.text.toString().trim()=="C"){
            if(TvTempo.text.toString().isNotEmpty()){
                var datosActuales: CharSequence = TvTempo.text as CharSequence
                TvTempo.text = datosActuales.subSequence(0,datosActuales.length-1)
            }else{
                primerNumero = Double.NaN
                segundoNumero = Double.NaN
                TvTempo.text = ""
                tvResul.text = ""

            }
        }else if (boton.text.toString().trim()=="CA"){
            primerNumero = Double.NaN
            segundoNumero = Double.NaN
            TvTempo.text = ""
            tvResul.text = ""
        }

    }
}