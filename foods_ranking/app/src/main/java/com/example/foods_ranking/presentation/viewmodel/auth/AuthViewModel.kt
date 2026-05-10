package com.example.foods_ranking.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {
    private val authFirebase = FirebaseAuth.getInstance()

    private val _authUIState = MutableStateFlow<AuthUIState>(
        AuthUIState.Loading
    )

    val authUIState = _authUIState.asStateFlow()

    init {
        val currentUser = authFirebase.currentUser

        _authUIState.value =
            if (currentUser != null) {
                AuthUIState.Authenticated(
                    currentUser.uid
                )
            } else {
                AuthUIState.Unauthenticated
            }
    }

    fun login(email: String, password: String) {
        _authUIState.value = AuthUIState.Loading

        authFirebase.signInWithEmailAndPassword(
            email,
            password
        )
            .addOnSuccessListener {
                val userId =
                    authFirebase.currentUser?.uid.orEmpty()

                _authUIState.value =
                    AuthUIState.Authenticated(
                        userId
                    )
            }
            .addOnFailureListener {
                print("error ${it.message}")
                _authUIState.value =
                    AuthUIState.Error(
                        it.message ?: "Unknown error"
                    )
            }
    }

    fun logout() {
        authFirebase.signOut()
        _authUIState.value =
            AuthUIState.Unauthenticated
    }
}