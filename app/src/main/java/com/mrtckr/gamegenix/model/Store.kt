package com.mrtckr.gamegenix.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class Store (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("store")
    @Expose
    var store: Shopping? = null

)