package Tings.com.tings.json

import Tings.com.tings.room.Movies
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesJson (
//        @Json(name = "movie_count")
//        val movieCount: Int = -1,
//    val id: Int,
        @Json(name = "title")
        val title: String,
        val image: String,
        val rating: String,
        val releaseYear: String,
//        @Json(name = "genre")
        val genre: List<String>
//    val overview: String
)
//data class genre(val name: String)
//data class genre(val : String)
