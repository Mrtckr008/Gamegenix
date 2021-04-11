package com.mrtckr.gamegenix.model.gamedetail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mrtckr.gamegenix.model.games.Genre
import com.mrtckr.gamegenix.model.games.ParentPlatform
import javax.annotation.Generated


@Generated("jsonschema2pojo")
class GameDetail {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("name_original")
    @Expose
    var nameOriginal: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("metacritic")
    @Expose
    var metacritic: Int? = null

    @SerializedName("metacritic_platforms")
    @Expose
    var metacriticPlatforms: List<MetacriticPlatform>? = null

    @SerializedName("released")
    @Expose
    var released: String? = null

    @SerializedName("tba")
    @Expose
    var tba: Boolean? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    @SerializedName("background_image")
    @Expose
    var backgroundImage: String? = null

    @SerializedName("background_image_additional")
    @Expose
    var backgroundImageAdditional: String? = null

    @SerializedName("website")
    @Expose
    var website: String? = null

    @SerializedName("rating")
    @Expose
    var rating: Double? = null

    @SerializedName("rating_top")
    @Expose
    var ratingTop: Int? = null

    @SerializedName("ratings")
    @Expose
    var ratings: List<Rating>? = null

    @SerializedName("reactions")
    @Expose
    var reactions: Reactions? = null

    @SerializedName("added")
    @Expose
    var added: Int? = null

    @SerializedName("added_by_status")
    @Expose
    var addedByStatus: AddedByStatus? = null

    @SerializedName("playtime")
    @Expose
    var playtime: Int? = null

    @SerializedName("screenshots_count")
    @Expose
    var screenshotsCount: Int? = null

    @SerializedName("movies_count")
    @Expose
    var moviesCount: Int? = null

    @SerializedName("creators_count")
    @Expose
    var creatorsCount: Int? = null

    @SerializedName("achievements_count")
    @Expose
    var achievementsCount: Int? = null

    @SerializedName("parent_achievements_count")
    @Expose
    var parentAchievementsCount: Int? = null

    @SerializedName("reddit_url")
    @Expose
    var redditUrl: String? = null

    @SerializedName("reddit_name")
    @Expose
    var redditName: String? = null

    @SerializedName("reddit_description")
    @Expose
    var redditDescription: String? = null

    @SerializedName("reddit_logo")
    @Expose
    var redditLogo: String? = null

    @SerializedName("reddit_count")
    @Expose
    var redditCount: Int? = null

    @SerializedName("twitch_count")
    @Expose
    var twitchCount: Int? = null

    @SerializedName("youtube_count")
    @Expose
    var youtubeCount: Int? = null

    @SerializedName("reviews_text_count")
    @Expose
    var reviewsTextCount: Int? = null

    @SerializedName("ratings_count")
    @Expose
    var ratingsCount: Int? = null

    @SerializedName("suggestions_count")
    @Expose
    var suggestionsCount: Int? = null

    @SerializedName("alternative_names")
    @Expose
    var alternativeNames: List<String>? = null

    @SerializedName("metacritic_url")
    @Expose
    var metacriticUrl: String? = null

    @SerializedName("parents_count")
    @Expose
    var parentsCount: Int? = null

    @SerializedName("additions_count")
    @Expose
    var additionsCount: Int? = null

    @SerializedName("game_series_count")
    @Expose
    var gameSeriesCount: Int? = null

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

    @SerializedName("parent_platforms")
    @Expose
    var parentPlatforms: List<ParentPlatform>? = null

    @SerializedName("platforms")
    @Expose
    var platforms: List<Platform__2>? = null

    @SerializedName("stores")
    @Expose
    var stores: List<Store>? = null

    @SerializedName("developers")
    @Expose
    var developers: List<Developer>? =
        null

    @SerializedName("genres")
    @Expose
    var genres: List<Genre>? = null

    @SerializedName("tags")
    @Expose
    var gameDetailTags: List<GameDetailTag>? = null

    @SerializedName("publishers")
    @Expose
    var publishers: List<Publisher>? = null

    @SerializedName("esrb_rating")
    @Expose
    var esrbRating: EsrbRating? = null

    @SerializedName("clip")
    @Expose
    var clip: Clip? = null

    @SerializedName("description_raw")
    @Expose
    var descriptionRaw: String? = null

}