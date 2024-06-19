package com.alishoumar.placeholder.domain.repository

import com.alishoumar.placeholder.domain.models.album.Album
import com.alishoumar.placeholder.domain.util.RequestState

interface AlbumRepository {

    suspend fun getAlbumsByUserId(userId:Int):RequestState<List<Album>>
}