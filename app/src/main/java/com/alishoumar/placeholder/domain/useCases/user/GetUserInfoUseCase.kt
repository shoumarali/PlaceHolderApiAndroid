package com.alishoumar.placeholder.domain.useCases.user

import com.alishoumar.placeholder.domain.models.user.UserInfo
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository
){

    operator fun invoke(id:Int):Flow<RequestState<UserInfo>> = flow {

        emit(RequestState.Loading())
        try {
            emit(RequestState.Success(userRepository.getSpecificUser(id)))
        }catch (e:Exception){
            emit(RequestState.Error(e))
        }
    }
}