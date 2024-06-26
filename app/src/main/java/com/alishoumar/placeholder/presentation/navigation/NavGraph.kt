package com.alishoumar.placeholder.presentation.navigation



import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.alishoumar.placeholder.presentation.screens.userInfo.UserInfoScreen
import com.alishoumar.placeholder.presentation.screens.userInfo.UserInfoViewModel
import com.alishoumar.placeholder.presentation.screens.users.UserScreen
import com.alishoumar.placeholder.presentation.screens.users.UserViewModel
import kotlinx.coroutines.delay
import kotlin.math.log

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
            },
            )

//        userInfoRoute(navController)



    }
}
@SuppressLint("UnrememberedMutableState")
fun NavGraphBuilder.userRoute(navigateToUserInfo:(Int?) -> Unit){
    composable(route = Screen.Users.route){

         val viewModel: UserViewModel = hiltViewModel()
         val state = viewModel.state
        var userByName by remember { mutableStateOf("") }


        LaunchedEffect(userByName) {
            if (userByName.length > 5) {
                delay(500)
               viewModel.loadUserByName(userByName)
            } else {
                viewModel.loadUsers()
            }
        }

        UserScreen(users = state.users ,
            onUserClick = navigateToUserInfo,
            userByName = userByName,
            onUserByNameChange = {
                userByName = it
            })
    }
}

fun NavGraphBuilder.userInfoRoute(

    onBackPress: () -> Unit,
    onPostClick:(Int) -> Unit,
    onAlbumClick:(Int) -> Unit
){
    composable(route = Screen.UserInfo.route){
        val viewModel: UserInfoViewModel = hiltViewModel()
        val user = viewModel.userInfoState.selectedUserInfo


        LaunchedEffect(key1 = Unit) {
            viewModel.loadUserInfo()
        }

        user?.let { it1 -> UserInfoScreen(
            userInfo = it1,
            onBackPress = onBackPress,
            onPostClick = onPostClick,
            onAlbumClick = onAlbumClick,
        ) }
    }
}



