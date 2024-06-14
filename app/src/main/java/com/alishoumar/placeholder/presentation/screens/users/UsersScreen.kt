package com.alishoumar.placeholder.presentation.screens.users

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
                 UserTopBar {

                 }
        },
        content = {

        }
    )
}


@Preview
@Composable
private fun viewUserScreen() {
    UserScreen()
}