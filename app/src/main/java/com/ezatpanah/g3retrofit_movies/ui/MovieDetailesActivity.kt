package com.ezatpanah.g3retrofit_movies.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.size.Scale
import com.ezatpanah.g3retrofit_movies.R
import com.ezatpanah.g3retrofit_movies.api.ApiClient
import com.ezatpanah.g3retrofit_movies.api.ApiServices
import com.ezatpanah.g3retrofit_movies.databinding.ActivityMovieDetailesBinding
import com.ezatpanah.g3retrofit_movies.response.MovieDetails
import com.ezatpanah.g3retrofit_movies.utils.Constants.POSTER_BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieDetailesActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieDetailesBinding

    private val api: ApiServices by lazy {
        ApiClient().getClient().create(ApiServices::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieId: Int = intent.getIntExtra("id", 1)
        binding.apply {
            //show loading
            prgBarMovies.visibility = View.VISIBLE
            //Call movies api
            val callMoviesApi = api.getMovieDetails(movieId)
            callMoviesApi.enqueue(object : Callback<MovieDetails> {
                override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                    Log.e("onFailure", "Err : ${response.code()}")
                    prgBarMovies.visibility = View.GONE
                    when (response.code()) {
                        in 200..299 -> {

                            response.body()?.let { itBody ->
                                val moviePosterURL = POSTER_BASE_URL + itBody.posterPath
                                imgMovie.load(moviePosterURL) {
                                    crossfade(true)
                                    placeholder(R.drawable.poster_placeholder)
                                    //scale(Scale.FILL)
                                    scale(Scale.FILL)
                                    // xml android:scaleType="fitXY"
                                    // xml android:scaleType="centerCrop"

                                }
                                imgMovieBack.load(moviePosterURL) {
                                    crossfade(true)
                                    placeholder(R.drawable.poster_placeholder)
                                    //scale(Scale.FILL)
                                    scale(Scale.FILL)
                                    // xml android:scaleType="fitXY"
                                    // xml android:scaleType="centerCrop"

                                }

                                tvMovieTitle.text = itBody.title
                                tvMovieTagLine.text = itBody.tagline
                                tvMovieDateRelease.text = itBody.releaseDate
                                tvMovieRating.text = itBody.voteAverage.toString()
                                tvMovieRuntime.text = itBody.runtime.toString()
                                tvMovieBudget.text = itBody.budget.toString()
                                tvMovieRevenue.text = itBody.revenue.toString()
                                tvMovieOverview.text = itBody.overview
                            }
                        }

                        in 300..399 -> {
                            Log.d("Response Code", " Redirection messages : ${response.code()}")
                        }
                        in 400..499 -> {
                            Log.d("Response Code", " Client error responses : ${response.code()}")
                        }
                        in 500..599 -> {
                            Log.d("Response Code", " Server error responses : ${response.code()}")
                        }

                    }
                }

                override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                    prgBarMovies.visibility = View.GONE
                    Log.e("onFailure", "Err : ${t.message}")
                }
            })
        }


    }

}