package com.alishoumar.placeholder.presentation.screens.comments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.CommentRepository
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants.COMMENTS_SCREEN_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val commentsRepo:CommentRepository,
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
        viewModelScope.launch {
            commentsState = commentsState.copy(
                loading = true
            )
            withContext(Dispatchers.IO){
                when(val result =
                    uiState.postId?.let { commentsRepo.getComments(postId = it.toInt()) }){
                    is RequestState.Success -> {
                        commentsState = commentsState.copy(
                            comments = result.data,
                        )
                    }
                    else -> {
                        commentsState = commentsState.copy(
                             error = result.toString()
                        )
                    }
                }
            }
        }
    }
}

private data class UiState(
    val postId:String? = null
)