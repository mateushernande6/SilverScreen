package br.com.silverscreen.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @field:SerializedName("errorMessage")
    val errorMessage: String? = null,

    @field:SerializedName("items")
    val items: List<MovieItem>?,
)

data class MovieItem(

    @field:SerializedName("imDbRating")
    val imDbRating: String? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("fullTitle")
    val fullTitle: String? = null,

    @field:SerializedName("imDbRatingCount")
    val imDbRatingCount: String? = null,

    @field:SerializedName("year")
    val year: String? = null,

    @field:SerializedName("rank")
    val rank: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("crew")
    val crew: String? = null,
)
