package com.mrtckr.gamegenix.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class Platform (
    @SerializedName("platform")
    @Expose
    var platform: ChildPlatform? = null,

    @SerializedName("released_at")
    @Expose
    var releasedAt: String? = null,

    @SerializedName("requirements_en")
    @Expose
    var requirementsEn: Any? = null,

    @SerializedName("requirements_ru")
    @Expose
    var requirementsRu: Any? = null

)