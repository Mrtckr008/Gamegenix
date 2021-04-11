package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class Requirements {
    @SerializedName("minimum")
    @Expose
    var minimum: String? = null

    @SerializedName("recommended")
    @Expose
    var recommended: String? = null

}