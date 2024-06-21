package com.alishoumar.placeholder.domain.repository

import com.alishoumar.placeholder.domain.models.post.Post
import com.alishoumar.placeholder.domain.util.RequestState

interface PostRepository {

    suspend fun getPosts(userId:Int):List<Post>
}