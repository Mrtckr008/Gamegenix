package com.mrtckr.gamegenix.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class Rating (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("count")
    @Expose
    var count: Int? = null,

    @SerializedName("percent")
    @Expose
    var percent: Double? = null

)