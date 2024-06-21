package com.alishoumar.placeholder.presentation.screens.users

import com.alishoumar.placeholder.domain.models.user.User


data class UserState (
    val users: List<User>? = null,
    val isLoading:Boolean = false,
    val error: String?=null
)