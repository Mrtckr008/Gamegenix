package com.mrtckr.gamegenix.model.games

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class AddedByStatus (
    @SerializedName("yet")
    @Expose
    var yet: Int? = null,

    @SerializedName("owned")
    @Expose
    var owned: Int? = null,

    @SerializedName("beaten")
    @Expose
    var beaten: Int? = null,

    @SerializedName("toplay")
    @Expose
    var toplay: Int? = null,

    @SerializedName("dropped")
    @Expose
    var dropped: Int? = null,

    @SerializedName("playing")
    @Expose
    var playing: Int? = null
)