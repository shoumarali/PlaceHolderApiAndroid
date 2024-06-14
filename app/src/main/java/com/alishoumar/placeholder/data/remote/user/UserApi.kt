package com.alishoumar.placeholder.data.remote.user

import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {


    @GET("users")
    suspend fun getAllUsers():List<UserDataDTO>

    @GET("users")
    suspend fun getSpecificUer(
        @Query("id") userId:Int
    ): UserDataDTO
}