package com.alishoumar.placeholder.data.repository

import com.alishoumar.placeholder.data.mappers.toCommentsData
import com.alishoumar.placeholder.data.remote.comment.CommentApi
import com.alishoumar.placeholder.domain.models.comment.Comment
import com.alishoumar.placeholder.domain.repository.CommentRepository
import com.alishoumar.placeholder.domain.util.RequestState
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi
): CommentRepository{
    override suspend fun getComments(postId: Int): RequestState<List<Comment>> {
        return try {
            RequestState.Success(
                data = commentApi.getCommentsByPost(postId = postId).toCommentsData()
            )
        }catch (e:Exception){
            RequestState.Error(e)
        }
    }


}