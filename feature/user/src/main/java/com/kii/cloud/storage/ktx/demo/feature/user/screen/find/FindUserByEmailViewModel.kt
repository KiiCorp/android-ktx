package com.kii.cloud.storage.ktx.demo.feature.user.screen.find

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kii.cloud.storage.ktx.KiiUserKTX
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindUserByEmailViewModel @Inject constructor(

) : ViewModel() {
    val inProgress = MutableStateFlow(false)

    fun find(email: String) {
        viewModelScope.launch {
            try {
                inProgress.value = true
                val user = KiiUserKTX.findUserByEmailAsync(email)
                println(user)
            } catch (e: Exception) {
                println(e)
            } finally {
                inProgress.value = false
            }
        }
    }
}