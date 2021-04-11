package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class Clips {
    @SerializedName("320")
    @Expose
    private var _320: String? = null

    @SerializedName("640")
    @Expose
    private var _640: String? = null

    @SerializedName("full")
    @Expose
    var full: String? = null

    fun get320(): String? {
        return _320
    }

    fun set320(_320: String?) {
        this._320 = _320
    }

    fun get640(): String? {
        return _640
    }

    fun set640(_640: String?) {
        this._640 = _640
    }

}