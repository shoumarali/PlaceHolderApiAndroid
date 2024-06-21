package com.alishoumar.placeholder.domain.useCases.comments

import com.alishoumar.placeholder.domain.models.comment.Comment
import com.alishoumar.placeholder.domain.repository.CommentRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCommentsUseCase @Inject constructor(private val repo:CommentRepository) {

    operator fun invoke(postId:Int):Flow<RequestState<List<Comment>>> = flow {
        emit(RequestState.Loading())

        try {
            emit(RequestState.Success(repo.getComments(postId)))
        }catch (e:Exception){
            emit(RequestState.Error(e))
        }
    }
}