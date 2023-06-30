package com.ezatpanah.g3retrofit_movies.response


import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /imagen_backdrop.jpg
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any,
    @SerializedName("budget")
    val budget: Int, // 63000000
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String, // http://www.foxmovies.com/movies/fight-club
    @SerializedName("id")
    val id: Int, // 550
    @SerializedName("imdb_id")
    val imdbId: String, // tt0137523 - Clasificación dentro del imdb
    @SerializedName("original_language")
    val originalLanguage: String, // en - Idioma
    @SerializedName("original_title")
    val originalTitle: String, // Fight Club - Título de la película
    @SerializedName("overview")
    val overview: String, // Ejemplo de texto a rellenar en el Overview.
    @SerializedName("popularity")
    val popularity: Double, // 49.547
    @SerializedName("poster_path")
    val posterPath: String, // /codigo_de_imagen.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String, // 1999-10-15 - Fecha de Estreno
    @SerializedName("revenue")
    val revenue: Int, // 100853753
    @SerializedName("runtime")
    val runtime: Int, // 139
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String, // Released - Estado
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("title")
    val title: String, // Fight Club - Título
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 8.4 - Porcentaje
    @SerializedName("vote_count")
    val voteCount: Int // 24337 - Cantidad de Votos
) {
    data class Genre(
        @SerializedName("id")
        val id: Int, // 18 - Genero
        @SerializedName("name")
        val name: String // Drama - Categoría
    )

    data class ProductionCompany(
        @SerializedName("id")
        val id: Int, // 508
        @SerializedName("logo_path")
        val logoPath: String, // /logo_ejemplo.png
        @SerializedName("name")
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String // US - País originario
    )

    data class ProductionCountry(
        @SerializedName("iso_3166_1")
        val iso31661: String,
        @SerializedName("name")
        val name: String
    )

    data class SpokenLanguage(
        @SerializedName("english_name")
        val englishName: String, // Idioma Inglés
        @SerializedName("iso_639_1")
        val iso6391: String, // en - Inglés
        @SerializedName("name")
        val name: String // Inglés
    )
}