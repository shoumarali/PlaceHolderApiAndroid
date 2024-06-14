package com.alishoumar.placeholder.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun setUpNavGraph(
    startDestination:String,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        userRoute()
        userInfoRoute()
        albumsRoute()
        photosRoute()
        postsRoute()
        commentsRoute()
    }
}

fun NavGraphBuilder.userRoute(){
    composable(route = Screen.Users.route){

    }
}

fun NavGraphBuilder.userInfoRoute(){
    composable(route = Screen.UserInfo.route){

    }
}

fun NavGraphBuilder.albumsRoute(){
    composable(route = Screen.Albums.route){

    }
}


fun NavGraphBuilder.photosRoute(){
    composable(route = Screen.Photos.route){

    }
}

fun NavGraphBuilder.postsRoute(){
    composable(route= Screen.Posts.route){

    }
}

fun NavGraphBuilder.commentsRoute(){
    composable(route = Screen.Comments.route){

    }
}