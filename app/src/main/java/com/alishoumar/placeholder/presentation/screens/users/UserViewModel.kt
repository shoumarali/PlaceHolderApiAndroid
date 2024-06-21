package com.alishoumar.placeholder.presentation.screens.users

import android.view.PixelCopy.Request
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.useCases.user.GetAllUsersUseCase
import com.alishoumar.placeholder.domain.useCases.user.GetUserByNameUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val getUserByNameUseCase: GetUserByNameUseCase
):ViewModel() {

     var state by mutableStateOf(UserState())
        private set

    fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllUsersUseCase().collect {
                state = when (it) {
                    is RequestState.Success -> state.copy(users = it.data)
                    is RequestState.Loading -> state.copy(isLoading = true)
                    else -> state.copy(error = "Something went wrong")
                }
            }
        }
    }


    fun loadUserByName(name:String){
        viewModelScope.launch(Dispatchers.IO) {
            getUserByNameUseCase(name).collect{
                state = when(it){
                    is RequestState.Success -> state.copy(users = it.data)
                    is RequestState.Loading -> state.copy(isLoading = true)
                    is RequestState.Error -> state.copy(error = "Something went wrong")
                }
            }
        }
    }
}