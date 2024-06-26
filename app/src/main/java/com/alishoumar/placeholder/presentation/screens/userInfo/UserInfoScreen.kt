package com.alishoumar.placeholder.presentation.screens.userInfo

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alishoumar.placeholder.domain.models.user.UserInfo
import com.alishoumar.placeholder.presentation.navigation.Screen
import com.alishoumar.placeholder.presentation.navigation.SetUpNavGraph
import com.alishoumar.placeholder.presentation.navigation.SetUpUserInfoNavGraph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInfoScreen(userInfo:UserInfo,
                   onBackPress:() -> Unit,
                   onPostClick:(Int) -> Unit,
                   onAlbumClick:(Int) -> Unit,
) {
    val navController = rememberNavController()
    var topBarHeight by remember { mutableIntStateOf(0) }
    val density = LocalDensity.current

    Scaffold (
        topBar = {
                 UserInfoTopBar(userInfo = userInfo, onBackPress = {
                     onBackPress()
                 } ,onHeightCalculated = { height ->
                     topBarHeight = height
                 })
        },
        bottomBar = {
                    UserInfoBottomBar(onPostClick = {
                        navController.navigate(Screen.Posts.passUserIdForPost(it))
                    }, onAlbumClick ={
                        navController.navigate(Screen.Albums.passUserIdForAlbums(it))
                    }, userInfoId = userInfo.id)
        },
        content = {

            val topPadding = with(density) { topBarHeight.toDp() }
            Box(
                modifier = Modifier
                    .padding(top = topPadding+12.dp)
                    .fillMaxSize()
            ) {
                SetUpUserInfoNavGraph(
                    startDestination = "test",
                    navController = navController
                )
            }

        }

    )
}
