package com.alishoumar.placeholder.domain.repository

import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.models.user.UserInfo
import com.alishoumar.placeholder.domain.util.RequestState

interface UserRepository {

    suspend fun getUsers():List<User>

    suspend fun getSpecificUser(userId:Int):RequestState<UserInfo>

    suspend fun getUsersByName(name:String):RequestState<List<User>>

}