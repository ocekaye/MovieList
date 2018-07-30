package id.setyatmoko.movielist.API.Services

import id.setyatmoko.movielist.Models.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/{id}")
    fun getMovieById(@Path("id") id : Int): Call<Movie>
}