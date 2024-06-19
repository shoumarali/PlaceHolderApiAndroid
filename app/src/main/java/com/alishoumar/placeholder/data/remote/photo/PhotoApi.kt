package com.alishoumar.placeholder.data.remote.photo

import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET("photos")
    suspend fun getPhotosByAlbum(
        @Query("albumId") albumId:Int
    ):List<PhotoDataDto>
}