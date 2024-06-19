package com.alishoumar.placeholder.presentation.screens.comments

import com.alishoumar.placeholder.domain.models.comment.Comment

data class CommentsState (
    val comments:List<Comment>?=null,
    val loading:Boolean?=false,
    val error:String?=null
)