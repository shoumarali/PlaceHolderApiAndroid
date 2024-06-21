package com.alishoumar.placeholder.presentation.screens.albums

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import com.alishoumar.placeholder.domain.useCases.album.GetAlbumUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getAlbumUseCase: GetAlbumUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {


    private var uiState by mutableStateOf(UiState())
    var albumsState by mutableStateOf(AlbumsState())
        private set

    init {
        getUserId()
    }

    private fun getUserId(){
        uiState = uiState.copy(
            savedStateHandle.get<String>(Constants.ALBUM_SCREEN_ARGUMENT_KEY)
        )
    }

    fun loadAlbums(){
     viewModelScope.launch(Dispatchers.IO) {
         uiState.userId?.let {userId ->
             getAlbumUseCase(userId.toInt()).collect{
                 albumsState = when(it){
                     is RequestState.Success -> {
                         Log.d("tag", "loadAlbums: ${it.data}")
                          albumsState.copy(albums = it.data)
                     }
                     is RequestState.Loading -> albumsState.copy(loading = true)
                     is RequestState.Error -> albumsState.copy(error = "Something went wrong")
                 }
             }
         }
     }
    }


}

private data class UiState(
    val userId:String?=null
)