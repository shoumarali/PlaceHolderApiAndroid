package com.alishoumar.placeholder.data.repository

import com.alishoumar.placeholder.data.mappers.toPostData
import com.alishoumar.placeholder.data.remote.post.PostApi
import com.alishoumar.placeholder.domain.models.post.Post
import com.alishoumar.placeholder.domain.repository.PostRepository
import com.alishoumar.placeholder.domain.util.RequestState
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postApi: PostApi
) : PostRepository {
    override suspend fun getPosts(userId: Int): List<Post> {
        return postApi.getPostsByUser(userId).toPostData()
    }

}