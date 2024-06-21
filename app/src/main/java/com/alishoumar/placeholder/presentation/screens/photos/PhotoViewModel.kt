package com.alishoumar.placeholder.presentation.screens.photos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alishoumar.placeholder.domain.repository.PhotoRepository
import com.alishoumar.placeholder.domain.util.RequestState
import com.alishoumar.placeholder.presentation.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private var uiState by mutableStateOf(UiState())
    var photoState by mutableStateOf(PhotoState())
        private set

    init {
        getAlbumId()
        Log.d("tag", ": ${uiState.albumId}")
    }

    private fun getAlbumId(){

        uiState = uiState.copy(
            albumId = savedStateHandle.get<String>(Constants.PHOTO_SCREEN_ARGUMENT_KEY)
        )
    }

    fun loadPhotos(){
        viewModelScope.launch {
            photoState = photoState.copy(
                loading = true
            )
            withContext(Dispatchers.IO){
                when(val result =
                    uiState.albumId?.let { photoRepository.getPhotosByAlbumId(it.toInt()) }){

                    is RequestState.Success ->{
                        photoState = photoState.copy(
                            photoList = result.data
                        )
                    }
                    else -> {
                        photoState = photoState.copy(
                            error = result.toString()
                        )
                    }
                }
            }
        }
    }
}

private data class UiState(
    val albumId:String?=null
)