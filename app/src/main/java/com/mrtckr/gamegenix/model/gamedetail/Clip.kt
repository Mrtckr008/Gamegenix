package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mrtckr.gamegenix.model.games.Clips
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class Clip {
    @SerializedName("clip")
    @Expose
    var clip: String? = null

    @SerializedName("clips")
    @Expose
    var clips: Clips? = null

    @SerializedName("video")
    @Expose
    var video: String? = null

    @SerializedName("preview")
    @Expose
    var preview: String? = null

}