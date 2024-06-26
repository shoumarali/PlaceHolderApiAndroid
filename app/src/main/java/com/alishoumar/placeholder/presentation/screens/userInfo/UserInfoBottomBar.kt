package com.alishoumar.placeholder.presentation.screens.userInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserInfoBottomBar(
    onPostClick: (Int) -> Unit,
    onAlbumClick: (Int) -> Unit,
    userInfoId: Int?
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentPadding = PaddingValues(horizontal = 30.dp),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { userInfoId?.let { onPostClick(it) } }) {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = Icons.Default.Email,
                        contentDescription = "Posts",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                IconButton(onClick = { userInfoId?.let { onAlbumClick(it) } }) {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = Icons.Default.Face,
                        contentDescription = "Albums",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    )
}
