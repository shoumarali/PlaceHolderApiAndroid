package com.alishoumar.placeholder.data.remote.album

import com.google.gson.annotations.SerializedName


data class AlbumDataDto (

    @SerializedName("userId" ) var userId : Int?    = null,
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null

)