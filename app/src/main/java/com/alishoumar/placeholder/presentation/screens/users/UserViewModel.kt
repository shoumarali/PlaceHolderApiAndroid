package com.alishoumar.placeholder.presentation.screens.users

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.useCases.GetAllUsersUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase,
):ViewModel() {

     var state by mutableStateOf(UserState())
        private set

    fun loadUsers() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            withContext(Dispatchers.IO){

                getAllUsersUseCase().onEach {
                    when(it){
                        is RequestState.Success -> {

                        }
                        else ->{

                        }
                    }
                }.launchIn(viewModelScope(Dispatchers.IO){

                })
            }
        }
    }

    fun loadUserByName(name:String) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            withContext(Dispatchers.IO){

                when(val result = repository.getUsersByName(name)){
                    is RequestState.Success ->{
                        state = state.copy(
                            users = result.data
                        )
                    }
                    else -> {
                        state = state.copy(
                            error = "There is no user with this name"
                        )
                    }
                }
            }
        }
    }
}