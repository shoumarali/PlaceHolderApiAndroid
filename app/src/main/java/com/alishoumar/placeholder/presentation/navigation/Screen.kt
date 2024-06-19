package com.alishoumar.placeholder.presentation.navigation

import com.alishoumar.placeholder.presentation.util.Constants.ALBUM_SCREEN_ARGUMENT_KEY
import com.alishoumar.placeholder.presentation.util.Constants.COMMENTS_SCREEN_ARGUMENT_KEY
import com.alishoumar.placeholder.presentation.util.Constants.PHOTO_SCREEN_ARGUMENT_KEY
import com.alishoumar.placeholder.presentation.util.Constants.POST_SCREEN_ARGUMENT_KEY
import com.alishoumar.placeholder.presentation.util.Constants.USER_INFO_SCREEN_ARGUMENT_KEY

sealed class Screen (val route:String){

    object Users:Screen(route = "users_screen")
    object UserInfo:Screen(
        route = "userInfo_screen?$USER_INFO_SCREEN_ARGUMENT_KEY={$USER_INFO_SCREEN_ARGUMENT_KEY}"
    ){
        fun passUserID(userId:Int)=
            "userInfo_screen?$USER_INFO_SCREEN_ARGUMENT_KEY=$userId"

    }

    object Posts:Screen(
        "posts_screen?$POST_SCREEN_ARGUMENT_KEY={$POST_SCREEN_ARGUMENT_KEY}"
    ){
        fun passUserIdForPost(userId:Int)=
            "posts_screen?$POST_SCREEN_ARGUMENT_KEY=$userId"

    }

    object Comments:Screen(
        "comments_screen?$COMMENTS_SCREEN_ARGUMENT_KEY={$COMMENTS_SCREEN_ARGUMENT_KEY}"
    ){
        fun passPostIdForComments(postId:Int)=
            "comments_screen?$COMMENTS_SCREEN_ARGUMENT_KEY=$postId"

    }

    object Albums:Screen(
        "albums_screen?$ALBUM_SCREEN_ARGUMENT_KEY={$ALBUM_SCREEN_ARGUMENT_KEY}"
    ){
        fun passUserIdForAlbums(userId:Int)=
            "albums_screen?$ALBUM_SCREEN_ARGUMENT_KEY=$userId"

    }
    object Photos:Screen(
        "photos_screen?$PHOTO_SCREEN_ARGUMENT_KEY={$PHOTO_SCREEN_ARGUMENT_KEY}"
    ){
        fun passAlbumIdForPhotos(albumId:Int)=
            "photos_screen?$PHOTO_SCREEN_ARGUMENT_KEY=$albumId"

    }
}