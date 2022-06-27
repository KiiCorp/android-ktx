package com.kii.cloud.storage.ktx.demo.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kii.cloud.storage.ktx.KiiUserKTX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    val inProgress = MutableStateFlow(false)
    val done = MutableStateFlow(false)

    fun login(username: String, password: String) {
        viewModelScope.launch {
            inProgress.value = true
            try {
                KiiUserKTX.loginAsync(username, password)
                done.value = true
            } catch (e: Exception) {
                println(e.message)
            } finally {
                inProgress.value = false
            }
        }
    }
}