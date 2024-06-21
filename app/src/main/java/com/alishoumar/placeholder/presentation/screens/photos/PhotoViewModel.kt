package com.alishoumar.placeholder.presentation.screens.photos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.PhotoRepository
import com.alishoumar.placeholder.domain.useCases.photo.GetPhotoUseCase
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private var uiState by mutableStateOf(UiState())
    var photoState by mutableStateOf(PhotoState())
        private set

    init {
        getAlbumId()
    }

    private fun getAlbumId(){

        uiState = uiState.copy(
            albumId = savedStateHandle.get<String>(Constants.PHOTO_SCREEN_ARGUMENT_KEY)
        )
    }

    fun loadPhotos(){
        viewModelScope.launch(Dispatchers.IO) {
            uiState.albumId?.let {
                albumId ->
                getPhotoUseCase(albumId.toInt()).collect{
                    photoState = when(it){
                        is RequestState.Success -> photoState.copy(photoList = it.data)
                        is RequestState.Loading -> photoState.copy(loading = true)
                        is RequestState.Error -> photoState.copy(error = "Something went wrong")
                    }
                }
            }
        }
    }
}

private data class UiState(
    val albumId:String?=null
)