package com.alishoumar.placeholder.domain.useCases.user

import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserByNameUseCase @Inject constructor(private val repo : UserRepository){

    operator fun invoke(name:String): Flow<RequestState<List<User>>> = flow {
        emit(RequestState.Loading())

        try {
            emit(RequestState.Success(repo.getUsersByName(name)))
        }catch (e: Exception){
            emit(RequestState.Error(exception = e))
        }

    }
}