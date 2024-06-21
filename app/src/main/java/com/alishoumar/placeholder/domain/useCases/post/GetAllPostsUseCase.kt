package com.alishoumar.placeholder.domain.useCases.post

import com.alishoumar.placeholder.domain.models.post.Post
import com.alishoumar.placeholder.domain.repository.PostRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(private val repo: PostRepository) {


    operator fun invoke(userId:Int): Flow<RequestState<List<Post>>> = flow{

        emit(RequestState.Loading())
        try {
            emit(RequestState.Success(repo.getPosts(userId)))
        }catch (e:Exception){
            emit(RequestState.Error(e))
        }
    }
}
