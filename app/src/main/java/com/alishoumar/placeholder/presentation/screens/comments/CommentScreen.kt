package com.alishoumar.placeholder.presentation.screens.comments

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.alishoumar.placeholder.domain.models.comment.Comment

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CommentScreen(
    comments:List<Comment>,
    onBackPress:() -> Unit
) {
    Scaffold (
//        topBar = {
//                 CommentTopBar (onBackPress = onBackPress)
//        },
        content = {
            CommentContent(comments = comments, paddingValues = it)
        }
    )
}