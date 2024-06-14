package com.alishoumar.placeholder.data.remote.user


import com.alishoumar.placeholder.data.remote.user.Geo


import com.google.gson.annotations.SerializedName


data class Address (

    @SerializedName("street"  ) var street  : String? = null,
    @SerializedName("suite"   ) var suite   : String? = null,
    @SerializedName("city"    ) var city    : String? = null,
    @SerializedName("zipcode" ) var zipcode : String? = null,
    @SerializedName("geo"     ) var geo     : Geo?    = Geo()

)