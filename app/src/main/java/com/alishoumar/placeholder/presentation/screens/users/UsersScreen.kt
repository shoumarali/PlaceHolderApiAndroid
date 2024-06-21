package com.alishoumar.placeholder.presentation.screens.users

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alishoumar.placeholder.domain.models.user.User

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen(
    users: List<User>?,
    userByName:String,
    onUserByNameChange:(String) -> Unit,
    onUserClick:(Int?) -> Unit
               ) {



    Scaffold (
        topBar = {
                 UserTopBar(userByName = userByName , onUserByNameChange = onUserByNameChange)
        },
        content = { paddingValues ->

            UsersContent(users = users,
                paddingValues= paddingValues,
                onUserClick = onUserClick,
            )
        }
    )
}


@Preview
@Composable
private fun viewUserScreen() {
//    UserScreen(){
//
//    }
}