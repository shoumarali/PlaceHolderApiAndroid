package com.alishoumar.placeholder.presentation.screens.users

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository:UserRepository
):ViewModel() {

     var state by mutableStateOf(UserState())
        private set

    fun loadUsers() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            withContext(Dispatchers.IO){

                when(val result = repository.getUsers()){
                    is RequestState.Success ->{
                        state = state.copy(
                            isLoading = false,
                            users = result.data
                        )
                    }
                    else -> {

                    }
                }


            }
        }
    }
}