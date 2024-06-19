package com.alishoumar.placeholder.presentation.screens.albums

import com.alishoumar.placeholder.domain.models.album.Album

data class AlbumsState(
    val albums:List<Album>? = null,
    val loading:Boolean = true,
    val error:String? = null
)