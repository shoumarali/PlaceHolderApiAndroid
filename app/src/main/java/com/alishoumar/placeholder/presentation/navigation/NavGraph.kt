package com.alishoumar.placeholder.presentation.navigation



import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alishoumar.placeholder.presentation.screens.albums.AlbumViewModel
import com.alishoumar.placeholder.presentation.screens.comments.CommentScreen
import com.alishoumar.placeholder.presentation.screens.comments.CommentsViewModel
import com.alishoumar.placeholder.presentation.screens.posts.PostsScreen
import com.alishoumar.placeholder.presentation.screens.posts.PostsViewModel
import com.alishoumar.placeholder.presentation.screens.userInfo.UserInfoScreen
import com.alishoumar.placeholder.presentation.screens.userInfo.UserInfoViewModel
import com.alishoumar.placeholder.presentation.screens.users.UserScreen
import com.alishoumar.placeholder.presentation.screens.users.UserViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SetUpNavGraph(
    startDestination:String,
    navController: NavHostController
) {


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        userRoute(navigateToUserInfo = {userId ->
            userId?.let {
                navController.navigate(Screen.UserInfo.passUserID(userId = userId))
            } }
        )
        userInfoRoute(onBackPress = {
            navController.popBackStack()
        },
            onPostClick = {
                          navController.navigate(Screen.Posts.passUserIdForPost(it))
            },
            onAlbumClick = {
                navController.navigate(Screen.Albums.passUserIdForAlbums(it))
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
        albumsRoute()
        photosRoute()
      
    }
}
fun NavGraphBuilder.userRoute(navigateToUserInfo:(Int?) -> Unit){
    composable(route = Screen.Users.route){

         val viewModel: UserViewModel = hiltViewModel()
         val state = viewModel.state
        LaunchedEffect(key1 = Unit) {
            viewModel.loadUsers()
        }

        UserScreen(users = state.users ,
            navigateToSearchScreen = {} ,
            onUserClick = navigateToUserInfo)
    }
}

fun NavGraphBuilder.userInfoRoute(
    onBackPress: () -> Unit,
                                  onPostClick:(Int) -> Unit,
                                  onAlbumClick:(Int) -> Unit){
    composable(route = Screen.UserInfo.route){
        val viewModel: UserInfoViewModel = hiltViewModel()
        val user = viewModel.userInfoState.selectedUserInfo

        LaunchedEffect(key1 = Unit) {
            viewModel.loadUserInfo()
        }


        user?.let { it1 -> UserInfoScreen(userInfo = it1,
            onBackPress = onBackPress,
            onPostClick = onPostClick,
            onAlbumClick = onAlbumClick
        ) }
    }
}

fun NavGraphBuilder.postsRoute(onBackPress: () -> Unit, onCommentsClick: (Int) -> Unit){
    composable(route= Screen.Posts.route){
       val viewModel:PostsViewModel= hiltViewModel()
        val posts = viewModel.postsState.posts

       LaunchedEffect(key1 = Unit) {
           viewModel.loadUserPosts()
       }
        if (posts != null) {
            PostsScreen(posts = posts, onBackButton = onBackPress, onCommentsClick = onCommentsClick)
        }
    }
}

fun NavGraphBuilder.albumsRoute(){
    composable(route = Screen.Albums.route){
        val viewModel : AlbumViewModel = hiltViewModel()
        val albums = viewModel.albumsState.albums
        LaunchedEffect(key1 = Unit) {
            viewModel.loadAlbums()
        }
        Log.d("album", "albumsRoute: $albums")
    }
}


fun NavGraphBuilder.photosRoute(){
    composable(route = Screen.Photos.route){

    }
}

fun NavGraphBuilder.commentsRoute(onBackPress: () -> Unit){
    composable(route = Screen.Comments.route){

        val viewModel:CommentsViewModel = hiltViewModel()
        val comments = viewModel.commentsState.comments

        LaunchedEffect(key1 = Unit) {
            viewModel.loadComments()
        }

        if (comments != null) {
            CommentScreen(comments = comments, onBackPress = onBackPress)
        }
    }
}