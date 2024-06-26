package com.alishoumar.placeholder.presentation.screens.userInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alishoumar.placeholder.domain.models.user.UserInfo
import java.nio.file.WatchEvent

@Composable
fun UserInfoContent(userInfo: UserInfo,
                    paddingValues: PaddingValues= PaddingValues(12.dp),
                    onPostClick:(Int) -> Unit,
                    onAlbumClick:(Int) -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding())
            .background(MaterialTheme.colorScheme.surface)
    ){

        Row ( modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    userInfo.name?.let { Text(text = it ,
                        color = MaterialTheme.colorScheme.onSurfaceVariant) }
                    Spacer(modifier = Modifier.size(12.dp))
                    userInfo.email?.let { Text(text = it,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ) }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Column {
                    userInfo.phone?.let { Text(text = it,
                        color = MaterialTheme.colorScheme.onSurfaceVariant) }
                }
            }
        }

        }

}

@Preview
@Composable
private fun PreviewUserInfoContent() {
//    UserInfoContent(userInfo = UserInfo(1,"ali","ali","76","fadsfas"), paddingValues = PaddingValues(16.dp))
}