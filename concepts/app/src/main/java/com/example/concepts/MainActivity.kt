package com.example.concepts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.concepts.ui.theme.ConceptsTheme
import kotlin.collections.listOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConceptsTheme {
                MyApp()
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

    var expanded by remember {
        mutableStateOf(false)
    }

    val text = if (expanded) "Close" else "Open"

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
                expanded = !expanded
            }) {
                Text(
                    text = text
                )
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            ListGreeting(names = listOf("Jetpack", "Compose", "Android"), modifier = Modifier.padding(24.dp))
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab")
        Button(
            modifier = modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text(text = "Click me")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    OnboardingScreen(onContinueClicked = {})
}