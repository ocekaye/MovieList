package id.setyatmoko.movielist.Main.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.setyatmoko.movielist.BaseFragment
import id.setyatmoko.movielist.R

class MovieListFragment : BaseFragment(){
    override var title: String
        get() = "Movie List"
        set(value) {title = value}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.dummy, container, false)
        val dummy = v.findViewById<TextView>(R.id.dummy)
        dummy.text = "Movie List"
        return v
    }
}