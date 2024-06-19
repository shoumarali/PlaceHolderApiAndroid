package com.alishoumar.placeholder.presentation.screens.userInfo

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.alishoumar.placeholder.domain.models.user.UserInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoTopBar (userInfo: UserInfo, onBackPress:() -> Unit){

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Arrow Icon"
                )
            }
        },
        title = { userInfo.userName?.let { androidx.compose.material3.Text(text = it) } },
        actions = {
            DeleteUserAction(
                selectedUser = userInfo.id,
                ){
                
            }
        }
    )
}

@Composable
fun DeleteUserAction(
    selectedUser: Int?,
    onDeleteConfirmed:() -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var openedDialog by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = "Delete") },
                onClick = {
                    expanded = false
                    openedDialog = true
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewUserInfoTopBar() {
    UserInfoTopBar(userInfo = UserInfo(1,"ali","ali","fasdfa","asdfa")) {

    }
}