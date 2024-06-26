package com.alishoumar.placeholder.presentation.screens.albums

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.alishoumar.placeholder.domain.models.album.Album

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AlbumsScreen(
    albums:List<Album>,
    onAlbumClick:(Int) -> Unit,
    onBackPress:() -> Unit
) {
    Scaffold (
//        topBar = {
//            AlbumsTopBar (onBackPress = onBackPress)
//        },
        content = {
            AlbumsContent(albums = albums, paddingValues = it, onAlbumClick = onAlbumClick)
        }
    )
}