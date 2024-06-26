package com.alishoumar.placeholder.presentation.screens.photos

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.alishoumar.placeholder.domain.models.photo.Photo


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PhotoScreen(
    photoList:List<Photo>?,
    onBackPress:() -> Unit
) {
    Scaffold (
//        topBar = {
//                 PhotoTopBar (onBackPress = onBackPress)
//        },
        content = {
            PhotoContent(photoList = photoList, it)
        }
    )
}