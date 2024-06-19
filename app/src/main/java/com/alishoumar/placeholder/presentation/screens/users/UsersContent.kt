package com.alishoumar.placeholder.presentation.screens.users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alishoumar.placeholder.domain.models.user.User
import java.util.Locale

@Composable
fun UsersContent(
    users:List<User>?,
    loading:Boolean = false,
    paddingValues: PaddingValues,
    onUserClick:(Int?) -> Unit
){
    if(!users.isNullOrEmpty() && !loading){
        LazyColumn (
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
        ){
            users.forEach{
                user ->
                item(key = user.id){
                    UserCard(user = user, onUserClick)
                    Spacer(modifier = Modifier.size(12.dp))
                }
            }
        }
    }else if(loading){
        CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary
        )
    }
    else{

    }
}

@Composable
fun UserCard(user:User, onUserClick: (Int?) -> Unit) {
    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(10.dp)
            .clickable { onUserClick(user.id) }
    ){
        Text(text = "${user.name}" ,
            color = MaterialTheme.colorScheme.onSurfaceVariant ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp)
                .clip(RoundedCornerShape(12.dp))
        )

    }
}


@Preview
@Composable
private fun PreviewUserContent() {
    val userList = listOf(User(1,"ali"),
        User(2,"ali")
        )
   
    UserCard(user = User(2,"ali")){

    }
}