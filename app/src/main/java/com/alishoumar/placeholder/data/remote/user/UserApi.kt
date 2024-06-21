package com.alishoumar.placeholder.data.remote.user

import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {


    @GET("users")
    suspend fun getAllUsers():List<UserDataDTO>

    @GET("users")
    suspend fun getSpecificUser(
        @Query("id") userId:Int
    ): List<UserDataDTO>

    @GET("users")
    suspend fun getUserByName(
        @Query("name") userId:String
    ): List<UserDataDTO>
}