package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class MetacriticPlatform {
    @SerializedName("metascore")
    @Expose
    var metascore: Int? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("platform")
    @Expose
    var platform: Platform? = null

}