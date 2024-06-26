package com.alishoumar.placeholder.presentation.screens.userInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.alishoumar.placeholder.domain.models.user.UserInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoTopBar(
    userInfo: UserInfo,
    onBackPress: () -> Unit,
    onHeightCalculated: (Int) -> Unit
) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Column(
        modifier = Modifier
            .onGloballyPositioned { coordinates ->
                size = coordinates.size
                onHeightCalculated(size.height)
            }
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = onBackPress) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Arrow Icon"
                    )
                }
            },
            title = { userInfo.userName?.let { Text(text = it) } },
            actions = {
                DeleteUserAction(
                    selectedUser = userInfo.id,
                ) {

                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    userInfo.name?.let {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.size(12.dp))
                    userInfo.email?.let {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Column {
                    userInfo.phone?.let {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DeleteUserAction(
    selectedUser: Int?,
    onDeleteConfirmed: () -> Unit
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
