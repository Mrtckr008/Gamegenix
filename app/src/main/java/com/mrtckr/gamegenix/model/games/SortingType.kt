package com.mrtckr.gamegenix.model.games

enum class SortingType (val keyword:String) {
    Default(""),
    Popularity("-metacritic"),
    Rating("-rating"),
    Released("-released"),
    Updated("-updated");

    companion object {
        fun valueOf(value: String) = values().find { it.keyword == value }
    }
}