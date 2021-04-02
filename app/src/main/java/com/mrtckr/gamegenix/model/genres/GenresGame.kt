package com.mrtckr.gamegenix.model.genres

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mrtckr.gamegenix.model.Game
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class GenresGame {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("added")
    @Expose
    var added: Int? = null

}

