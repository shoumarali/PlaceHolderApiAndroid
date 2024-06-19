package com.alishoumar.placeholder.data.repository

import com.alishoumar.placeholder.data.mappers.toAlbumData
import com.alishoumar.placeholder.data.remote.album.AlbumApi
import com.alishoumar.placeholder.domain.models.album.Album
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import com.alishoumar.placeholder.domain.util.RequestState
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumApi: AlbumApi
):AlbumRepository {
    override suspend fun getAlbumsByUserId(userId: Int): RequestState<List<Album>> {
        return try {
            RequestState.Success(data = albumApi.getAlbumByUser(userId).toAlbumData())
        }catch(e: Exception){
            RequestState.Error(e)
        }
    }

}