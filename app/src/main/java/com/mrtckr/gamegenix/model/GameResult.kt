package com.mrtckr.gamegenix.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
data class GameResult (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("slug")
    @Expose
    var slug: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("released")
    @Expose
    var released: String? = null,

    @SerializedName("tba")
    @Expose
    var tba: Boolean? = null,

    @SerializedName("background_image")
    @Expose
    var backgroundImage: String? = null,

    @SerializedName("rating")
    @Expose
    var rating: Double? = null,

    @SerializedName("rating_top")
    @Expose
    var ratingTop: Int? = null,

    @SerializedName("ratings")
    @Expose
    var ratings: MutableList<Rating?>? = null,

    @SerializedName("ratings_count")
    @Expose
    var ratingsCount: Int? = null,

    @SerializedName("reviews_text_count")
    @Expose
    var reviewsTextCount: Int? = null,

    @SerializedName("added")
    @Expose
    var added: Int? = null,

    @SerializedName("added_by_status")
    @Expose
    var addedByStatus: AddedByStatus? = null,

    @SerializedName("metacritic")
    @Expose
    var metacritic: Int? = null,

    @SerializedName("playtime")
    @Expose
    var playtime: Int? = null,

    @SerializedName("suggestions_count")
    @Expose
    var suggestionsCount: Int? = null,

    @SerializedName("updated")
    @Expose
    var updated: String? = null,

    @SerializedName("user_game")
    @Expose
    var userGame: Any? = null,

    @SerializedName("reviews_count")
    @Expose
    var reviewsCount: Int? = null,

    @SerializedName("saturated_color")
    @Expose
    var saturatedColor: String? = null,

    @SerializedName("dominant_color")
    @Expose
    var dominantColor: String? = null,

    @SerializedName("platforms")
    @Expose
    var platforms: MutableList<Platform?>? =
        null,

    @SerializedName("parent_platforms")
    @Expose
    var parentPlatforms: MutableList<ParentPlatform?>? = null,

    @SerializedName("genres")
    @Expose
    var genres: MutableList<Genre?>? = null,

    @SerializedName("stores")
    @Expose
    var stores: MutableList<Store>? = null,

    @SerializedName("clip")
    @Expose
    var clip: Clip? = null,

    @SerializedName("tags")
    @Expose
    var tags: MutableList<Tag?>? = null,

    @SerializedName("esrb_rating")
    @Expose
    var esrbRating: EsrbRating? = null,

    @SerializedName("short_screenshots")
    @Expose
    var shortScreenshots: MutableList<ShortScreenshot?>? = null

)