package id.setyatmoko.movielist.Models

import java.util.*

data class Genres(val _id: String = UUID.randomUUID().toString()){
    var id : Int = 0
    var name : String = ""
}