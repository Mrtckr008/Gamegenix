package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class Store {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("store")
    @Expose
    var store: Store__1? = null

}