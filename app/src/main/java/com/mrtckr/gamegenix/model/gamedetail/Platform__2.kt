package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class Platform__2 {
    @SerializedName("platform")
    @Expose
    var platform: Platform__3? = null

    @SerializedName("released_at")
    @Expose
    var releasedAt: String? = null

    @SerializedName("requirements")
    @Expose
    var requirements: Requirements? = null

}