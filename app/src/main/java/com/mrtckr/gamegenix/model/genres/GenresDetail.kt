package com.mrtckr.gamegenix.model.genres

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class GenresDetail {
    @SerializedName("WARNING")
    @Expose
    var warning: String? = null

    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("next")
    @Expose
    var next: Any? = null

    @SerializedName("previous")
    @Expose
    var previous: Any? = null

    @SerializedName("results")
    @Expose
    var results: List<GenresResult>? = null

}



