package com.alishoumar.placeholder.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.PostRepository
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsRepo: PostRepository,
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
        viewModelScope.launch {
            postsState = postsState.copy(
                isLoading = true,
            )
            withContext(Dispatchers.IO){

                when(val result = uiState.userId?.let {
                    postsRepo.getPosts(it.toInt())
                }){
                    is RequestState.Success ->{
                        postsState = postsState.copy(
                            isLoading = false,
                            posts = result.data
                        )
                    }
                    else -> {
                        postsState = postsState.copy(
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
