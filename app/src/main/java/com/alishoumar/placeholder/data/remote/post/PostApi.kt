package com.alishoumar.placeholder.data.remote.post

import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("posts")
    suspend fun getPostsByUser(
        @Query("userId") userId:Int
    ):List<PostDataDto>
}