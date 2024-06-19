package com.alishoumar.placeholder.domain.repository

import com.alishoumar.placeholder.domain.models.comment.Comment
import com.alishoumar.placeholder.domain.util.RequestState


interface CommentRepository {

    suspend fun getComments(postId:Int):RequestState<List<Comment>>
}