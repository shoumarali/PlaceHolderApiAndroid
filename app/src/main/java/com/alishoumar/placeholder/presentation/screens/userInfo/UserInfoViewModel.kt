package com.alishoumar.placeholder.presentation.screens.userInfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants.USER_INFO_SCREEN_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val repo:UserRepository,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {

    private var uiState by mutableStateOf(UiState())
    var userInfoState by mutableStateOf(UserInfoState())
        private set
    init {
        getUserIdArgument()
    }

    private fun getUserIdArgument(){
        uiState = uiState.copy(
            userId = savedStateHandle.get<String>(key =USER_INFO_SCREEN_ARGUMENT_KEY)
        )
    }

    fun loadUserInfo(){
        viewModelScope.launch {
            userInfoState = userInfoState.copy(
                isLoading = true,
            )
            withContext(Dispatchers.IO){

                when(val result = uiState.userId?.let {
                    repo.getSpecificUser(it.toInt())
                }){
                    is RequestState.Success ->{
                        userInfoState = userInfoState.copy(
                             selectedUserInfo = result.data
                        )
                    }
                    else -> {
                        userInfoState = userInfoState.copy(
                            isLoading = false,
                            error = "Something went wrong"
                        )
                    }
                }


            }
        }
    }
}

 private data class UiState( val userId:String?=null)