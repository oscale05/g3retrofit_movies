package com.ezatpanah.g3retrofit_movies.response


import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) {
    data class Result(
        @SerializedName("adult")
        val adult: Boolean, // false
        @SerializedName("backdrop_path")
        val backdropPath: String, // /imagen_backdrop.jpg
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("original_language")
        val originalLanguage: String, // Ejemplo de idioma - en
        @SerializedName("original_title")
        val originalTitle: String, // Ejemplo de título original - Doctor Strange in the Multiverse of Madness
        @SerializedName("overview")
        val overview: String, // Ejemplo de Overview - Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.
        @SerializedName("popularity")
        val popularity: Double,
        @SerializedName("poster_path")
        val posterPath: String, // /imagen_poster.jpg
        @SerializedName("release_date")
        val releaseDate: String, // 2022-05-04 - Fecha de Estreno
        @SerializedName("title")
        val title: String, // Doctor Strange in the Multiverse of Madness - Ejemplo de título
        @SerializedName("video")
        val video: Boolean, // false
        @SerializedName("vote_average")
        val voteAverage: Double, // 7.5 - Promedio de votos
        @SerializedName("vote_count")
        val voteCount: Int // 3987 - Cantidad de votos
    )
}