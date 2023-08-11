package com.example.prueba1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Honorarios()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Honorarios() {
    var sueldobruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cálculo Sueldo Líquido", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = sueldobruto,
            onValueChange = { sueldobruto = it },
            label = { Text("Sueldo Bruto") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val sueldobrutoNumero = sueldobruto.toIntOrNull() ?: 0
                val sueldoliquido = calcularSueldoLiquido(sueldobrutoNumero)
                resultado = "El sueldo líquido es $ $sueldoliquido"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = resultado,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(56.dp))
        Button(
            onClick = {
                val intent = Intent(contexto, MainActivity::class.java)
                contexto.startActivity(intent)
            }
        ) {
            Text(text = "<- Volver")
        }
    }
}

fun calcularSueldoLiquido(sueldobruto: Int): Double {
    return sueldobruto - (sueldobruto * 0.13)
}
