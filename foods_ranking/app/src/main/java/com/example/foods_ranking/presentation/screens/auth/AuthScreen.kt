package com.example.foods_ranking.presentation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foods_ranking.presentation.viewmodel.auth.AuthUIState
import com.example.foods_ranking.presentation.viewmodel.auth.AuthViewModel

@Composable
fun AuthScreen() {

    val authViewModel: AuthViewModel = viewModel()
    val authUIState by authViewModel.authUIState.collectAsState()

    val isLoading = authUIState is AuthUIState.Loading

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AuthHeader()
            AuthForm(
                onLogin = { email, password ->
                    authViewModel.login(email = email, password = password)
                },
                loading = isLoading
            )
        }
    }
}

@Composable
fun AuthHeader() {
    Column(
        modifier = Modifier.padding(bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "🍔 Food Rank",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome, sign in to continue.",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun AuthForm(
    onLogin: (String, String) -> Unit,
    loading: Boolean
) {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.End
    ) {
        OutlinedTextField(
            value = emailState,
            onValueChange = {
                emailState = it
            },
            label = { Text(text = "Write your email") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = passwordState,
            onValueChange = {
                passwordState = it
            },
            label = { Text(text = "Write your password") },
            visualTransformation =
                PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(),
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.4f),
            onClick = {
                onLogin(emailState, passwordState)
            }
        ) {
            Text(
                text = if (loading) "Loading..." else "Sign in",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}