package id.setyatmoko.movielist.Models

import java.util.UUID.randomUUID

data class Movie(val _id: String = randomUUID().toString()) {
    var popularity: Number = 0
    var vote_count : Number = 0
    var video : Boolean = false
    var poster_path : String = ""
    var id : Int = 0
    var adult : Boolean = false
    lateinit var backdrop_path : String
    var original_language : String = ""
    var original_title : String = ""
    var genre_ids : List<Number> = ArrayList()
    var title : String = ""
    var vote_average : Number = 0
    var overview : String = ""
    var release_date : String = ""
    var budget : Number = 0
    var genres : List<Genres> = ArrayList()
    var production_companies : List<ProductionCompanies> = ArrayList()
    var status : String = ""
    var tagline : String = ""
    var runtime : Int = 0
}

data class ProductionCompanies(val _id: String = randomUUID().toString()){
    var id : Int = 0
    var logo_path : String = ""
    var name : String = ""
    var origin_country : String = ""
}