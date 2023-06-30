package com.ezatpanah.g3retrofit_movies.api

import com.ezatpanah.g3retrofit_movies.response.MovieDetails
import com.ezatpanah.g3retrofit_movies.response.MoviesListResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {



    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetails>

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Call<MoviesListResponse>

}