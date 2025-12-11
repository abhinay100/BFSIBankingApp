package com.abhinay.bfsibankingapp.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinay.bfsibankingapp.domain.repository.BankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Abhinay on 08/12/25.
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: BankingRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String, onSuccess: () -> Unit) {

        viewModelScope.launch {

            _uiState.value = LoginUiState.Loading
            repository.login(email, password).fold(
                onSuccess = {
                    _uiState.value = LoginUiState.Success
                    onSuccess()
                },
                onFailure = { error ->
                    _uiState.value = LoginUiState.Error(
                        error.message ?: "Login failed"
                    )
                }
            )

        }

    }
}