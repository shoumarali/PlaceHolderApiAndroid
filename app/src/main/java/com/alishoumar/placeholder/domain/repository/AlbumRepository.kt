package com.alishoumar.placeholder.domain.repository

import com.alishoumar.placeholder.domain.models.album.Album

interface AlbumRepository {
    suspend fun getAlbumsByUserId(userId:Int):List<Album>

}