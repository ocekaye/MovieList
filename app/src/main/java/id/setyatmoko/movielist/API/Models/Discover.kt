package id.setyatmoko.movielist.API.Models
import id.setyatmoko.movielist.Models.Movie
import java.util.UUID.randomUUID

data class Discover(val _id: String = randomUUID().toString()) {
    var page : Int = 0
    var total_results : Int = 0
    var total_pages : Int = 0
    var results : List<Movie> = ArrayList()
}