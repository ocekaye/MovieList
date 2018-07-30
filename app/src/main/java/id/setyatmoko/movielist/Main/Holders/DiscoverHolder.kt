package id.setyatmoko.movielist.Main.Holders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import id.setyatmoko.movielist.R

class DiscoverHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    constructor(container: ViewGroup) : this(LayoutInflater.from(container.context).inflate(R.layout.item_movie, container, false))
    val title : TextView = itemView!!.findViewById(R.id.txtTitle)
    val rating : TextView = itemView!!.findViewById(R.id.txtRating)
    val cover : ImageView = itemView!!.findViewById(R.id.imgCover)
}