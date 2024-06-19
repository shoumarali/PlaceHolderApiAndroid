package com.alishoumar.placeholder.presentation.screens.userInfo

import com.alishoumar.placeholder.domain.models.user.UserInfo

data class UserInfoState(
    val selectedUserInfo: UserInfo? =null,
    val isLoading:Boolean = false,
    val error:String? = null
)