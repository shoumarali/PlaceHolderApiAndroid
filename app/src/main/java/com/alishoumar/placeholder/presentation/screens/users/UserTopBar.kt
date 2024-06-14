package com.alishoumar.placeholder.presentation.screens.users

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTopBar(modifier: Modifier = Modifier,
               searchValue:String="",
               onSearchValueChange:(String)-> Unit
) {
    TopAppBar(
        modifier = modifier
                ,
        title ={
            TextField(
                modifier = modifier.fillMaxSize(),
                value = "ali",
                onValueChange = onSearchValueChange,
                placeholder = {Text(text = "Search for a user")}
                )
        }
    )
}


@Preview
@Composable
private fun PreviewTopAppBar() {
    UserTopBar(){

    }
}