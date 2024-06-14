package com.alishoumar.placeholder.data.remote.album

import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApi {

    @GET("albums")
    suspend fun getAlbumByUser(
        @Query("userId") userId:Int
    ):AlbumDataDto
}