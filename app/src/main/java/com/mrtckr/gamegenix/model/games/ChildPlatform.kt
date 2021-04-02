package com.mrtckr.gamegenix.model.games

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class ChildPlatform (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("slug")
    @Expose
    var slug: String? = null,

    @SerializedName("image")
    @Expose
    var image: Any? = null,

    @SerializedName("year_end")
    @Expose
    var yearEnd: Any? = null,

    @SerializedName("year_start")
    @Expose
    var yearStart: Any? = null,

    @SerializedName("games_count")
    @Expose
    var gamesCount: Int? = null,

    @SerializedName("image_background")
    @Expose
    var imageBackground: String? = null

)