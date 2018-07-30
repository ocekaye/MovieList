package id.setyatmoko.movielist.API.Services

import id.setyatmoko.movielist.API.Models.Discover
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {
    @GET("discover/movie")
    fun getDiscoverYear(@Query("primary_release_year") year : Int): Call<Discover>
}