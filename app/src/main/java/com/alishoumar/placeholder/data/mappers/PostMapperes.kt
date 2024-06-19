package com.alishoumar.placeholder.data.mappers

import com.alishoumar.placeholder.data.remote.post.PostDataDto
import com.alishoumar.placeholder.domain.models.post.Post


fun List<PostDataDto>.toPostData():List<Post>{
    return this.map {
        post ->
        Post(
            id = post.id,
            title = post.title,
            body = post.body
        )
    }
}