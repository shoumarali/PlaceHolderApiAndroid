package com.alishoumar.placeholder.presentation.screens.users

import com.alishoumar.placeholder.domain.models.user.User


data class UserState (
    val users: List<User>,
    val isLoading:Boolean
)