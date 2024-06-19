package com.alishoumar.placeholder.presentation.screens.albums

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumsRepo:AlbumRepository,
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
     viewModelScope.launch {
         albumsState = albumsState.copy(
             loading = true
         )
         withContext(Dispatchers.IO){
             when(val result = uiState
                 .userId?.let { albumsRepo.getAlbumsByUserId(it.toInt()) }){
                 is RequestState.Success -> {
                     albumsState  = albumsState.copy(
                         albums = result.data
                     )
                 }
                 else -> {
                     albumsState = albumsState.copy(
                         error= result.toString()
                     )
                 }
             }
         }
     }

    }

}

private data class UiState(
    val userId:String?=null
)