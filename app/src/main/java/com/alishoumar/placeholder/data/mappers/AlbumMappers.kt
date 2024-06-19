package com.alishoumar.placeholder.data.mappers

import com.alishoumar.placeholder.data.remote.album.AlbumDataDto
import com.alishoumar.placeholder.domain.models.album.Album

fun List<AlbumDataDto>.toAlbumData():List<Album>{
    return this.map {
        albumDto ->
        Album(
            id= albumDto.id,
            title = albumDto.title
            )
    }
}