package com.alishoumar.placeholder.domain.repository

import com.alishoumar.placeholder.domain.models.photo.Photo
import com.alishoumar.placeholder.domain.util.RequestState

interface PhotoRepository {

    suspend fun getPhotosByAlbumId(albumId:Int ):RequestState<List<Photo>>

}