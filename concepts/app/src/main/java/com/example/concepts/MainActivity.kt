package com.example.concepts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.concepts.ui.theme.ConceptsTheme
import kotlin.collections.listOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConceptsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListGreeting(names = listOf("Jetpack", "Compose", "Android"), modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListGreeting(
    names: List<String>,
    modifier: Modifier = Modifier
) {
    Column() {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val expanded = remember {
        mutableStateOf(false)
    }

    val text = if (expanded.value) "Close" else "Open"

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier.padding(10.dp).fillMaxWidth()
        ) {
            Text(
                text = "Hello $name!",
                modifier = modifier.weight(1f),
                color = MaterialTheme.colorScheme.primary
            )
            Button(onClick = {
                expanded.value = !expanded.value
            }) {
                Text(
                    text = text
                )
            }
        }
    }
}