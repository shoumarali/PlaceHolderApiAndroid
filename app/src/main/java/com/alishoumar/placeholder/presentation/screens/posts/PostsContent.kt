package com.alishoumar.placeholder.presentation.screens.posts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alishoumar.placeholder.domain.models.post.Post

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostsContent(
    posts:List<Post>,
    paddingValues: PaddingValues,
    onCommentsClick:(Int) -> Unit) {

    LazyColumn (
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .padding(bottom = paddingValues.calculateBottomPadding())
            .padding(horizontal = 24.dp)
    ){
        posts.forEach{
            post ->
            stickyHeader (key = post.title){
                Row (
                    Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(vertical = 14.dp)
                ){
                    post.title?.let { Text(text = it,
                        color = MaterialTheme.colorScheme.onSurface
                    ) }
                }
            }
            item(key = post.id ){
                Surface (
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(all = 12.dp)
                ){
                    Column (
                        modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant)
                    ){
                        post.body?.let { Text(text = it,
                            color=MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.background(
                                MaterialTheme.colorScheme.surfaceVariant)
                        )}
                        Row (
                            modifier = Modifier.padding(all = 14.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ){
                            Button(onClick = { post.id?.let { onCommentsClick(it) } }) {
                                Text(text = "Comments" , color = MaterialTheme.colorScheme.onSurface)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Prev() {
//    PostsContent(posts = listOf(
//        Post(id = 1,title = "lol", body = "flkasjdlfjalfjdlkakjfl")
//    ), paddingValues = PaddingValues(12.dp)
//    )
}

