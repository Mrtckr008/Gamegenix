package com.mrtckr.gamegenix.model.games

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class Clip (
    @SerializedName("clip")
    @Expose
    var clip: String? = null,

    @SerializedName("clips")
    @Expose
    var clips: Clips? = null,

    @SerializedName("video")
    @Expose
    var video: String? = null,

    @SerializedName("preview")
    @Expose
    var preview: String? = null

)