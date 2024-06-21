package com.alishoumar.placeholder.presentation.screens.comments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.CommentRepository
import com.alishoumar.placeholder.domain.useCases.comments.GetAllCommentsUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants.COMMENTS_SCREEN_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val getAllCommentsUseCase: GetAllCommentsUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var commentsState by mutableStateOf(CommentsState())
        private set

    private var uiState by mutableStateOf(UiState())

    init {
        getPostState()
    }

    private fun getPostState(){
        uiState = uiState.copy(postId = savedStateHandle.get<String>(COMMENTS_SCREEN_ARGUMENT_KEY))
    }

    fun loadComments(){
        viewModelScope.launch (Dispatchers.IO){
           uiState.postId?.let { postId ->
               getAllCommentsUseCase.invoke(postId.toInt()).collect{
                   commentsState = when(it){
                       is RequestState.Success -> commentsState.copy(comments = it.data)
                       is RequestState.Loading -> commentsState.copy(loading = true)
                       is RequestState.Error -> commentsState.copy(error = "Something went wrong")
                   }
               }
           }
        }
    }
}

private data class UiState(
    val postId:String? = null
)