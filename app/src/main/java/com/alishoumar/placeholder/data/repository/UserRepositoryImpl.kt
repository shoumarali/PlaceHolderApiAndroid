package com.alishoumar.placeholder.data.repository

import com.alishoumar.placeholder.data.mappers.toUserData
import com.alishoumar.placeholder.data.mappers.toUserInfo
import com.alishoumar.placeholder.data.remote.user.UserApi
import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.models.user.UserInfo
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.util.RequestState
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
):UserRepository {

    override suspend fun getUsers(): RequestState<List<User>> {
        return try {
            RequestState.Success(
                data = userApi.getAllUsers().toUserData()
            )
        }catch (e :Exception){
            RequestState.Error(Exception(e))
        }
    }

    override suspend fun getSpecificUser(userId: Int): RequestState<UserInfo> {
        return try {
            RequestState.Success(
                data = userApi.getSpecificUser(userId = userId).toUserInfo()
            )
        } catch (e : Exception){
            RequestState.Error(Exception(e))
        }
    }
}