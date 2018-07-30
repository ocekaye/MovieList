package id.setyatmoko.movielist.Movie

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.wang.avi.AVLoadingIndicatorView
import id.setyatmoko.movielist.Models.Movie
import id.setyatmoko.movielist.R
import retrofit2.Call
import id.setyatmoko.movielist.API.ServiceGenerator
import id.setyatmoko.movielist.API.Services.MovieService
import id.setyatmoko.movielist.BaseActivity
import retrofit2.Callback
import retrofit2.Response
import id.setyatmoko.movielist.Utils.TimeUtils
import id.setyatmoko.movielist.Movie.Adapters.GenreAdapter

class MovieActivity : AppCompatActivity() {
    var id : Int = 0
    private var callMovie : Call<Movie>? = null
    private var movie : Movie = Movie()

    private lateinit var collapsingToolbar : ViewGroup
    private lateinit var mainContent : ViewGroup

    private lateinit var imgBackdrop : ImageView
    private lateinit var imgPoster : ImageView
    private lateinit var txtDuration : TextView
    private lateinit var txtRating : TextView
    private lateinit var loading : AVLoadingIndicatorView
    lateinit var txtTitle : TextView
    lateinit var txtTagline : TextView
    lateinit var txtStatus : TextView
    lateinit var txtOverview : TextView

    lateinit var rvGenre : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_movie)
        collapsingToolbar = findViewById(R.id.appBarLayout)
        mainContent = findViewById(R.id.main_content)
        loading = findViewById(R.id.loading)
        attachToolbar()
        id = intent.getIntExtra("id", 0)
        title = ""
        val movieService = ServiceGenerator.createService(this, MovieService::class.java)
        callMovie = movieService.getMovieById(id)
        callMovie!!.enqueue(movieCallbak)
    }

    private val movieCallbak : Callback<Movie> = object:Callback<Movie>{
        override fun onFailure(call: Call<Movie>?, t: Throwable?) {
            Log.e("get movie", t!!.message)
        }

        override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
            loading.hide()
            setupView(response!!.body()!!)
        }
    }

    private fun setupView(_movie : Movie){
        movie = _movie
        title = movie.title
        attachMainView()
        runOnUiThread{
            txtRating.text = movie.vote_average.toString()
            val time = TimeUtils.minutesToHours(movie.runtime)
            txtDuration.text = "${time[0]}h ${time[1]}m"
            txtTitle.text = movie.title
            txtTagline.text = movie.tagline
            txtStatus.text = movie.status
            txtOverview.text = movie.overview
            try {
                Glide.with(this).load(ServiceGenerator.getImage(movie.backdrop_path)).into(imgBackdrop)
            } catch (e : Exception){
                Glide.with(this).load(ServiceGenerator.getImage(movie.poster_path)).into(imgBackdrop)
            }
            Glide.with(this).load(ServiceGenerator.getImage(movie.poster_path)).into(imgPoster)
        }

        val genreAdapter = GenreAdapter()
        rvGenre.adapter = genreAdapter
        rvGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        genreAdapter.add(movie.genres)
    }

    private fun attachToolbar(){
        val v = LayoutInflater.from(this).inflate(R.layout.movie_collapsing_toolbar, collapsingToolbar, false)
        imgBackdrop = v.findViewById(R.id.imgHeader)
        txtDuration = v.findViewById(R.id.txtDuration)
        txtRating = v.findViewById(R.id.txtRating)
        collapsingToolbar.addView(v)
        setSupportActionBar(v.findViewById(R.id.toolbar))
    }

    private fun attachMainView(){
        val v = LayoutInflater.from(this).inflate(R.layout.movie_main_content, mainContent, false)
        imgPoster = v.findViewById(R.id.imgPoster)
        txtTitle = v.findViewById(R.id.txtTitle)
        txtTagline = v.findViewById(R.id.txtTagline)
        txtStatus = v.findViewById(R.id.txtStatus)
        txtOverview = v.findViewById(R.id.txtOverview)
        rvGenre = v.findViewById(R.id.rvGenres)
        mainContent.addView(v)
    }

    override fun onPause() {
        super.onPause()
        callMovie?.cancel()
    }


}