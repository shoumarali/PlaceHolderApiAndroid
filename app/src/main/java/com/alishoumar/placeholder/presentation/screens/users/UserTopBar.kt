package com.alishoumar.placeholder.presentation.screens.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTopBar(modifier: Modifier = Modifier,
               userByName:String,
               onUserByNameChange:(String) -> Unit
) {
    var showSearch by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surface)
                ,
        title ={
            if(showSearch) {
                TextField(
                    value = userByName,
                    onValueChange = {onUserByNameChange(it)},
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Search...") }
                )
            }else {
                Text(text = "Users", color = MaterialTheme.colorScheme.onSurface)
            }
        },
        actions = {
            IconButton(onClick =  {
                showSearch = !showSearch
            }) {
                Icon(

                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    )
}


//@Preview
//@Composable
//private fun PreviewTopAppBar() {
//    UserTopBar(){
//
//    }
//}