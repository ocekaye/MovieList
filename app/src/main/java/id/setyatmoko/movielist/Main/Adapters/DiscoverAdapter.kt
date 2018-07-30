package id.setyatmoko.movielist.Main.Adapters

import android.content.Intent
import android.os.Handler
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.setyatmoko.movielist.API.ServiceGenerator
import id.setyatmoko.movielist.Adapters.BaseAdapter
import id.setyatmoko.movielist.BaseActivity
import id.setyatmoko.movielist.Main.Holders.DiscoverHolder
import id.setyatmoko.movielist.Models.Movie
import id.setyatmoko.movielist.Movie.MovieActivity

class DiscoverAdapter(val activity: BaseActivity) : BaseAdapter<Movie, DiscoverHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverHolder {
        return DiscoverHolder(parent)
    }

    override fun onBindViewHolder(holder: DiscoverHolder, position: Int) {
        val movie = get(position)
        holder.title.text = movie.title
        holder.rating.text = movie.vote_average.toString()
        Glide.with(holder.itemView.context).load(ServiceGenerator.getImage(movie.poster_path)).into(holder.cover)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MovieActivity::class.java)
            intent.putExtra("id", movie.id)
            Log.e("id", movie.id.toString())
            activity.startActivity(intent)
        }
    }
}