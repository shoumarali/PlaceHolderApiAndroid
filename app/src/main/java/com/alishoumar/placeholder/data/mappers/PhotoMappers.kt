package com.alishoumar.placeholder.data.mappers

import com.alishoumar.placeholder.data.remote.photo.PhotoDataDto
import com.alishoumar.placeholder.domain.models.photo.Photo


fun List<PhotoDataDto>.toPhotoData():List<Photo>{
    return this.map {
        photo ->
        Photo(url = photo.url)
    }
}