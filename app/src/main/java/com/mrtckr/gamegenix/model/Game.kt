package com.mrtckr.gamegenix.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class AddedByStatus {
    @SerializedName("yet")
    @Expose
    var yet: Int? = null

    @SerializedName("owned")
    @Expose
    var owned: Int? = null

    @SerializedName("beaten")
    @Expose
    var beaten: Int? = null

    @SerializedName("toplay")
    @Expose
    var toplay: Int? = null

    @SerializedName("dropped")
    @Expose
    var dropped: Int? = null

    @SerializedName("playing")
    @Expose
    var playing: Int? = null
}

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

@Generated("jsonschema2pojo")
class EsrbRating {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

}

@Generated("jsonschema2pojo")
class Game {
    @SerializedName("WARNING")
    @Expose
    var warning: String? = null

    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("next")
    @Expose
    var next: String? = null

    @SerializedName("previous")
    @Expose
    var previous: Any? = null

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

}

@Generated("jsonschema2pojo")
class Genre {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("games_count")
    @Expose
    var gamesCount: Int? = null

    @SerializedName("image_background")
    @Expose
    var imageBackground: String? = null

}

@Generated("jsonschema2pojo")
class ParentPlatform {
    @SerializedName("platform")
    @Expose
    var platform: Platform__2? = null

}

@Generated("jsonschema2pojo")
class Platform {
    @SerializedName("platform")
    @Expose
    var platform: Platform__1? = null

    @SerializedName("released_at")
    @Expose
    var releasedAt: String? = null

    @SerializedName("requirements_en")
    @Expose
    var requirementsEn: Any? = null

    @SerializedName("requirements_ru")
    @Expose
    var requirementsRu: Any? = null

}

@Generated("jsonschema2pojo")
class Platform__1 {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("image")
    @Expose
    var image: Any? = null

    @SerializedName("year_end")
    @Expose
    var yearEnd: Any? = null

    @SerializedName("year_start")
    @Expose
    var yearStart: Any? = null

    @SerializedName("games_count")
    @Expose
    var gamesCount: Int? = null

    @SerializedName("image_background")
    @Expose
    var imageBackground: String? = null

}

@Generated("jsonschema2pojo")
class Platform__2 {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

}

@Generated("jsonschema2pojo")
class Rating {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("percent")
    @Expose
    var percent: Double? = null

}

@Generated("jsonschema2pojo")
class Result {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("released")
    @Expose
    var released: String? = null

    @SerializedName("tba")
    @Expose
    var tba: Boolean? = null

    @SerializedName("background_image")
    @Expose
    var backgroundImage: String? = null

    @SerializedName("rating")
    @Expose
    var rating: Double? = null

    @SerializedName("rating_top")
    @Expose
    var ratingTop: Int? = null

    @SerializedName("ratings")
    @Expose
    var ratings: MutableList<Rating?>? = null

    @SerializedName("ratings_count")
    @Expose
    var ratingsCount: Int? = null

    @SerializedName("reviews_text_count")
    @Expose
    var reviewsTextCount: Int? = null

    @SerializedName("added")
    @Expose
    var added: Int? = null

    @SerializedName("added_by_status")
    @Expose
    var addedByStatus: AddedByStatus? = null

    @SerializedName("metacritic")
    @Expose
    var metacritic: Int? = null

    @SerializedName("playtime")
    @Expose
    var playtime: Int? = null

    @SerializedName("suggestions_count")
    @Expose
    var suggestionsCount: Int? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    @SerializedName("user_game")
    @Expose
    var userGame: Any? = null

    @SerializedName("reviews_count")
    @Expose
    var reviewsCount: Int? = null

    @SerializedName("saturated_color")
    @Expose
    var saturatedColor: String? = null

    @SerializedName("dominant_color")
    @Expose
    var dominantColor: String? = null

    @SerializedName("platforms")
    @Expose
    var platforms: MutableList<Platform?>? =
        null

    @SerializedName("parent_platforms")
    @Expose
    var parentPlatforms: MutableList<ParentPlatform?>? = null

    @SerializedName("genres")
    @Expose
    var genres: MutableList<Genre?>? = null

    @SerializedName("stores")
    @Expose
    var stores: MutableList<Store>? = null

    @SerializedName("clip")
    @Expose
    var clip: Clip? = null

    @SerializedName("tags")
    @Expose
    var tags: MutableList<Tag?>? = null

    @SerializedName("esrb_rating")
    @Expose
    var esrbRating: EsrbRating? = null

    @SerializedName("short_screenshots")
    @Expose
    var shortScreenshots: MutableList<ShortScreenshot?>? = null

}

@Generated("jsonschema2pojo")
class ShortScreenshot {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

}

@Generated("jsonschema2pojo")
class Store {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("store")
    @Expose
    var store: Store__1? = null

}

@Generated("jsonschema2pojo")
class Store__1 {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("domain")
    @Expose
    var domain: String? = null

    @SerializedName("games_count")
    @Expose
    var gamesCount: Int? = null

    @SerializedName("image_background")
    @Expose
    var imageBackground: String? = null

}

@Generated("jsonschema2pojo")
class Tag {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("games_count")
    @Expose
    var gamesCount: Int? = null

    @SerializedName("image_background")
    @Expose
    var imageBackground: String? = null

}