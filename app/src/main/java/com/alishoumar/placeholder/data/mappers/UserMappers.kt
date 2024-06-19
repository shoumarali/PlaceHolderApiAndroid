package com.alishoumar.placeholder.data.mappers

import com.alishoumar.placeholder.data.remote.user.UserDataDTO
import com.alishoumar.placeholder.domain.models.user.User
import com.alishoumar.placeholder.domain.models.user.UserInfo


fun List<UserDataDTO>.toUserData():List<User>{

        return this.map {
            userDataDTO ->
            User(
                id = userDataDTO.id,
                name = userDataDTO.name
            )
        }
    }

fun List<UserDataDTO>.toUserInfo():UserInfo{

    val user = this[0]

    return UserInfo(
        id = user.id,
        name= user.name,
        userName = user.username,
        email = user.email,
        phone = user.phone
    )
}
