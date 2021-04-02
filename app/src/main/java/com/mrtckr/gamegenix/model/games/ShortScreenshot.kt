package com.mrtckr.gamegenix.model.games

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class ShortScreenshot (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null

)