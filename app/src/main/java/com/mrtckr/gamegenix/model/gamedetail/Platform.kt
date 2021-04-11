package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class Platform {
    @SerializedName("platform")
    @Expose
    var platform: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

}