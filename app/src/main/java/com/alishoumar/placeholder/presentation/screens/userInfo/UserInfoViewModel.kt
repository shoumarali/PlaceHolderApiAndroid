package com.alishoumar.placeholder.presentation.screens.userInfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.useCases.user.GetUserByNameUseCase
import com.alishoumar.placeholder.domain.useCases.user.GetUserInfoUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants.USER_INFO_SCREEN_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
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
        viewModelScope.launch(Dispatchers.IO) {
            uiState.userId?.let { it ->
                getUserInfoUseCase(it.toInt()).collect{
                    userInfoState = when(it){
                        is RequestState.Success -> userInfoState.copy(selectedUserInfo = it.data)
                        is RequestState.Loading -> userInfoState.copy(isLoading = true)
                        is RequestState.Error -> userInfoState.copy(error = "Something went wrong")
                    }
                }
            }
        }
    }
}

 private data class UiState( val userId:String?=null)