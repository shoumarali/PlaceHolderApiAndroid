package com.alishoumar.placeholder.domain.useCases

import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor( private val userRepository: UserRepository) {


    operator fun invoke(): Flow<RequestState<List<User>>> = flow {

        emit(RequestState.Loading())
        try {
            val result = userRepository.getUsers()
            emit(RequestState.Success(result))
        }catch (e:Exception){
            RequestState.Error(e)
        }

    }
}