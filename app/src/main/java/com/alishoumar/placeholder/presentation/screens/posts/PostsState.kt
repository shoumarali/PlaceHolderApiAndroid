package com.alishoumar.placeholder.presentation.screens.posts

import com.alishoumar.placeholder.domain.models.post.Post

data class PostsState(
    val posts:List<Post>? = null,
    val isLoading:Boolean = false,
    val error:String?=null
)