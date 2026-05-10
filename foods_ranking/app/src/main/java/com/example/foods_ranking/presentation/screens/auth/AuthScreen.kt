package com.example.foods_ranking.presentation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen() {

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            AuthHeader()
            AuthForm()
        }
    }
}

@Composable
fun AuthHeader() {
    Column(
        modifier = Modifier.padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "🍔 Food Rank",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome, Sing in to continue",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun AuthForm() {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.End
    ) {
        OutlinedTextField(
            state = emailState,
            label = { Text(text = "Write your email") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            state = passwordState,
            label = { Text(text = "Write your password") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.4f),
            onClick = {}
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}