package id.setyatmoko.movielist.Movie.Adapters

import android.view.ViewGroup
import id.setyatmoko.movielist.Adapters.BaseAdapter
import id.setyatmoko.movielist.BaseActivity
import id.setyatmoko.movielist.Models.Genres
import id.setyatmoko.movielist.Models.Movie
import id.setyatmoko.movielist.Movie.Holders.GenreHolder

class GenreAdapter : BaseAdapter<Genres, GenreHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder {
        return GenreHolder(parent)
    }

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        val genre = get(position)
        holder.title.text = genre.name
    }
}