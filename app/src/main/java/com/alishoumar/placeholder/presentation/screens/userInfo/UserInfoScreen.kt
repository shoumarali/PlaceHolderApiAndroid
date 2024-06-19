package com.alishoumar.placeholder.presentation.screens.userInfo

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.alishoumar.placeholder.domain.models.user.UserInfo


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInfoScreen(userInfo:UserInfo,
                   onBackPress:() -> Unit,
                   onPostClick:(Int) -> Unit,
                   onAlbumClick:(Int) -> Unit) {

    Scaffold (
        topBar = {
                 UserInfoTopBar(userInfo = userInfo, onBackPress = onBackPress )
        },
        content = {
            UserInfoContent(userInfo = userInfo ,
                paddingValues = it,
                onPostClick = onPostClick,
                onAlbumClick = onAlbumClick)
        }
    )
}