package com.alishoumar.placeholder.presentation.screens.albums

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alishoumar.placeholder.domain.models.album.Album

@Composable
fun AlbumsContent(albums:List<Album>,
                  paddingValues: PaddingValues,
                  onAlbumClick:(Int) -> Unit
                  ) {
    LazyColumn (
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.surface
            )
            .padding(top = paddingValues.calculateTopPadding())
    ){
        albums.forEach{
            album ->
            item(key = album.id){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable { album.id?.let { onAlbumClick(it) } },

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    album.title?.let { Text(text = it ,
                        color =  MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                            .padding(horizontal = 12.dp)
                        ) }
                }
                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    }
}

//@Preview
//@Composable
//private fun Preview() {
//    AlbumsContent(albums = listOf(Album(id = 1,title = "test"))
//        , paddingValues = PaddingValues(12.dp))
//}
