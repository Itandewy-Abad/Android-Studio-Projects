package com.example.compose7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }
}

@Composable
fun Login() {
    // Constante para la longitud mínima de la clave
    val minClaveLength = 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        var usuario by remember { mutableStateOf("") }
        var clave by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("Sin resultado") }

        // Campo de texto para el nombre de usuario
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            singleLine = true
        )

        // Campo de texto para la clave
        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it },
            label = { Text("Clave") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        // Botón de confirmar
        Button(
            onClick = {
                val mensajes = mutableListOf<String>()
                if (usuario.isEmpty()) mensajes.add("El usuario no puede estar vacío.")
                if (clave.length < minClaveLength) mensajes.add("La clave debe tener al menos $minClaveLength caracteres.")
                resultado = if (mensajes.isEmpty()) "Datos válidos" else mensajes.joinToString("\n")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Confirmar")
        }

        // Resultado
        Text(
            text = resultado,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
    }
}
