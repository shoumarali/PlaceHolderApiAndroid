package com.alishoumar.placeholder.data.repository

import com.alishoumar.placeholder.data.mappers.toPhotoData
import com.alishoumar.placeholder.data.remote.photo.PhotoApi
import com.alishoumar.placeholder.domain.models.photo.Photo
import com.alishoumar.placeholder.domain.repository.PhotoRepository
import com.alishoumar.placeholder.domain.util.RequestState
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApi: PhotoApi
): PhotoRepository {

    override suspend fun getPhotosByAlbumId(albumId: Int): RequestState<List<Photo>> {
        return try {
            RequestState.Success(
                data = photoApi.getPhotosByAlbum(albumId).toPhotoData()
            )
        }catch (e: Exception){
            RequestState.Error(e)
        }
    }

}