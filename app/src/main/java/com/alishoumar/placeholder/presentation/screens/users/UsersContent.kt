package com.alishoumar.placeholder.presentation.screens.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alishoumar.placeholder.domain.models.user.User

@Composable
fun UsersContent(
    modifier: Modifier = Modifier,
    users:List<User>
) {
    if(users.isNotEmpty()){
        LazyColumn (

        ){
            users.forEach { user ->
                item(item(user))
            }
        }
    }
    else{
        
    }
}


@Preview
@Composable
private fun PreviewUserContent() {
    val userList = listOf(User(1,"ali","alis","alelshoumar@gmail.com"),
        User(2,"ali","alis","alelshoumar@gmail.com")
        )
    UsersContent(users = userList)
}