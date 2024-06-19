package com.alishoumar.placeholder.data.remote.comment

import retrofit2.http.GET
import retrofit2.http.Query

interface CommentApi {

    @GET("comments")
    suspend fun getCommentsByPost(
        @Query("postId") postId : Int
    ):List<CommentDataDto>
}