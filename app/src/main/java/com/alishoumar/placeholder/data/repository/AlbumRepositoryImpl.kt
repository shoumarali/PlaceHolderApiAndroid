package com.alishoumar.placeholder.data.repository

import com.alishoumar.placeholder.data.mappers.toAlbumData
import com.alishoumar.placeholder.data.remote.album.AlbumApi
import com.alishoumar.placeholder.domain.models.album.Album
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumApi: AlbumApi
):AlbumRepository {
    override suspend fun getAlbumsByUserId(userId: Int): List<Album> {
        return albumApi.getAlbumByUser(userId).toAlbumData()
    }

}