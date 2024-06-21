package com.alishoumar.placeholder.presentation.screens.photos

import com.alishoumar.placeholder.domain.models.photo.Photo

data class PhotoState (
    val photoList:List<Photo>? =null,
    val loading:Boolean = false,
    val error:String?=null
)