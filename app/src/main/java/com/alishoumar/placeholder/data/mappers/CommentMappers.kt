package com.alishoumar.placeholder.data.mappers

import com.alishoumar.placeholder.data.remote.comment.CommentDataDto
import com.alishoumar.placeholder.domain.models.comment.Comment

fun List<CommentDataDto>.toCommentsData():List<Comment>{
    return this.map {
        comment ->
        Comment(name = comment.name,body = comment.body)
    }
}