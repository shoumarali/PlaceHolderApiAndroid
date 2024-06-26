package com.alishoumar.placeholder.presentation.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alishoumar.placeholder.presentation.screens.albums.AlbumViewModel
import com.alishoumar.placeholder.presentation.screens.albums.AlbumsScreen
import com.alishoumar.placeholder.presentation.screens.comments.CommentScreen
import com.alishoumar.placeholder.presentation.screens.comments.CommentsViewModel
import com.alishoumar.placeholder.presentation.screens.photos.PhotoScreen
import com.alishoumar.placeholder.presentation.screens.photos.PhotoViewModel
import com.alishoumar.placeholder.presentation.screens.posts.PostsScreen
import com.alishoumar.placeholder.presentation.screens.posts.PostsViewModel

@Composable
fun SetUpUserInfoNavGraph(
    startDestination:String,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){


        composable("test"){
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){

            }
        }

        albumsRoute(onBackPress = {
            navController.popBackStack()
        },
            onAlbumClick = {
                navController.navigate(Screen.Photos.passAlbumIdForPhotos(it))
            })

        postsRoute(onBackPress = {
            navController.popBackStack()
        },
            onCommentsClick = {
                navController.navigate(Screen.Comments.passPostIdForComments( it))
            })

        commentsRoute(onBackPress = {
            navController.popBackStack()
        })

        photosRoute(
            onBackPress = {
                navController.popBackStack()
            }
        )
    }
}



fun NavGraphBuilder.postsRoute(onBackPress: () -> Unit, onCommentsClick: (Int) -> Unit){
    composable(route= Screen.Posts.route){
        val viewModel: PostsViewModel = hiltViewModel()
        val posts = viewModel.postsState.posts

        Log.d("tag", "postsRoute: ${it.arguments?.get("userId")}")

        LaunchedEffect(key1 = Unit) {
            viewModel.loadUserPosts()
        }

        if (posts != null) {

            PostsScreen(posts = posts, onBackButton = onBackPress, onCommentsClick = onCommentsClick)

        }
    }
}

fun NavGraphBuilder.albumsRoute(onBackPress: () -> Unit,
                                onAlbumClick: (Int) -> Unit){
    composable(route = Screen.Albums.route){
        val viewModel : AlbumViewModel = hiltViewModel()
        val albums = viewModel.albumsState.albums
        LaunchedEffect(key1 = Unit) {
            viewModel.loadAlbums()
        }
        if (albums != null) {
            AlbumsScreen(albums = albums,
                onBackPress = onBackPress,
                onAlbumClick = onAlbumClick)

        }
    }
}


fun NavGraphBuilder.photosRoute(onBackPress: () -> Unit){
    composable(route = Screen.Photos.route){
        val viewModel: PhotoViewModel = hiltViewModel()
        val photos = viewModel.photoState.photoList

        LaunchedEffect(key1 = Unit) {
            viewModel.loadPhotos()
        }

        PhotoScreen(photoList = photos, onBackPress = onBackPress)
    }
}

fun NavGraphBuilder.commentsRoute(onBackPress: () -> Unit){
    composable(route = Screen.Comments.route){

        val viewModel: CommentsViewModel = hiltViewModel()
        val comments = viewModel.commentsState.comments

        LaunchedEffect(key1 = Unit) {
            viewModel.loadComments()
        }

        if (comments != null) {
            CommentScreen(comments = comments, onBackPress = onBackPress)
        }
    }
}