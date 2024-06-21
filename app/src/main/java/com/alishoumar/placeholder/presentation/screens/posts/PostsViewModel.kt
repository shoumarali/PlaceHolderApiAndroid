package com.alishoumar.placeholder.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.useCases.post.GetAllPostsUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {

    private var uiState by mutableStateOf(UiState())
    var postsState by mutableStateOf(PostsState())
        private set
    init {
        getUserIdArgument()
    }
    private fun getUserIdArgument(){
        uiState = uiState.copy(
            userId = savedStateHandle.get<String>(key = Constants.POST_SCREEN_ARGUMENT_KEY)
        )
    }

    fun loadUserPosts(){
        viewModelScope.launch(Dispatchers.IO){
            uiState.userId?.let {userId ->
                getAllPostsUseCase(userId.toInt()).collect{
                    postsState = when(it){
                        is RequestState.Success -> postsState.copy(posts = it.data)
                        is RequestState.Loading -> postsState.copy(isLoading = true)
                        is RequestState.Error -> postsState.copy(error = "Something went wrong")
                    }
                }
            }
        }
    }

}

private data class UiState( val userId:String?=null)
