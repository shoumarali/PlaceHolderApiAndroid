package com.alishoumar.placeholder.presentation.screens.photos

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.alishoumar.placeholder.domain.models.photo.Photo
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage

@Composable
fun PhotoContent(photoList: List<Photo>?,
                 paddingValues: PaddingValues) {
    if (photoList == null || photoList.isEmpty()) {

        return
    }

    LazyVerticalGrid(
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
            .padding(12.dp),
        columns = GridCells.Fixed(2),
    ) {
        items(photoList.size) { index ->
            PhotoItem(photo = photoList[index])
        }
    }
}

@Composable
fun PhotoItem(photo: Photo) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        val imageShape: Shape = RoundedCornerShape(8.dp)
        val imageSize: Dp = 200.dp
        AsyncImage(
            modifier = Modifier
                .clip(imageShape)
                .size(imageSize)
                .fillMaxWidth(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo.url)
                .crossfade(true)
                .build(),
            contentDescription = "Photo ID: ${photo.id}",
            contentScale = ContentScale.Crop
        )
    }
}
