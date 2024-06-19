package com.alishoumar.placeholder.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.alishoumar.placeholder.domain.models.post.Post

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostsScreen(posts:List<Post>, onBackButton:() -> Unit, onCommentsClick:(Int) -> Unit) {
    Scaffold (
        topBar = {
                 PostTopBar(postTitle = "Posts",onBackButton)
        },
        content = {
            PostsContent(posts = posts, paddingValues = it, onCommentsClick = onCommentsClick)
        }
    )
}