package com.mrtckr.gamegenix.model.games

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class Clips (
    @SerializedName("320")
    @Expose
    private var _320: String? = null,

    @SerializedName("640")
    @Expose
    private var _640: String? = null,

    @SerializedName("full")
    @Expose
    var full: String? = null

)