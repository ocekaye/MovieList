package id.setyatmoko.movielist.Movie.Holders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import id.setyatmoko.movielist.R

class GenreHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    constructor(container: ViewGroup) : this(LayoutInflater.from(container.context).inflate(R.layout.item_genre, container, false))
    val title : TextView = itemView!!.findViewById(R.id.txtGenre)
}