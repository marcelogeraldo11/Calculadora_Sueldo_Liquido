package com.example.prueba1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val sueldoEditText = findViewById<EditText>(R.id.sueldoEditText)
        val calcularButton = findViewById<Button>(R.id.calcularButton)
        val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)

        btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        calcularButton.setOnClickListener {
            val sueldoBrutoText = sueldoEditText.text.toString()

            if (sueldoBrutoText.isNotEmpty() && sueldoBrutoText.matches(Regex("\\d+"))) {
                val sueldoBruto = sueldoBrutoText.toInt()
                val sueldoLiquido = calcularSueldoLiquido(sueldoBruto)
                resultadoTextView.text = "Sueldo líquido: $sueldoLiquido"
            } else {
                resultadoTextView.text = "Ingrese un número válido"
            }
        }
    }


    private fun calcularSueldoLiquido(sueldoBruto: Int): Double {
        return sueldoBruto - (sueldoBruto * 0.20)
    }
}
