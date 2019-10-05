package Tings.com.tings.json
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import Tings.com.tings.R
import Tings.com.tings.room.MovieRoomDatabase
//import Tings.com.tings.room.Movies
import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import kotlinx.android.synthetic.main.activity_get_json.*
import java.io.StringReader

class GetJsonActivity : AppCompatActivity() {
    lateinit var URL:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_json)
        setSupportActionBar(toolbar1)
        URL ="http://api.androidhive.info/json/movies.json"
        getJsonFromUrl()


    }
    private fun getJsonFromUrl() {
        try {

            Fuel.post(URL, listOf()).responseJson { request, response, result ->
                Log.d("plzzzzz", result.get().content)
                onTaskCompleted(result.get().content)
            }
        } catch (e: Exception) {

        } finally {

        }
    }
    private fun onTaskCompleted(json: String) {
        println(json)
//        val result = Klaxon()
//                .parse<Movies>("""
//
//                {
//                    "title" : "title"
//                    "image" : "wwww.sss"
//                    "rating" : 88
//                    "name" : "John Smith",
//                }
//        """)
        //here we parse the json into movies and then into an array of movies
        val klaxon = Klaxon()
        val moviesArray = arrayListOf<mov>()
        JsonReader(StringReader(json)).use {//jsonArray
            reader -> reader.beginArray {
            while (reader.hasNext()) {
                val curMovie = klaxon.parse<mov>(reader)
                moviesArray.add(curMovie!!)
            }
        }
        }
        Log.v("klaxon","passed")
        if(moviesArray==null || moviesArray.size==0)
            Log.v("moviesArr"," is null")
        insertMoviesToRoom(moviesArray)


//        Log.v("now","the time")
//        println("rasa is : "+result?.rating.toString())


//        var data= mutableListOf<Movies>()//todo transform from json to room

//        println("res is: " + (result?.get(0)?.image ))

    }
    //here we will insert the parsed json into the room db:
    fun insertMoviesToRoom( jsonMovies:List<mov>){
//        GlobalScope.launch {
        var movieDatabase: MovieRoomDatabase =
                Room.databaseBuilder(applicationContext,
                        MovieRoomDatabase::class.java, "movies")
                        .fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build()
        Log.v("insertMoviesToRoom","passed")

//            movieDatabase.daoAccess().getMovies()

            jsonMovies?.forEach {
                Log.v("before println it","passed")
//                println(it)
                var myMovie= Tings.com.tings.room.Movie(it.title,it.image,it.rating,it.releaseYear)//Movies()
                Log.v("before it title","passed")
//                myMovie.setTitle(it.title)
//                Log.v("before it image","passed")
//                myMovie.setImage(it.image)
//                Log.v("before it rating","passed")
//                myMovie.setRating(it.rating)
//                myMovie.setRelaseYear(it.releaseYear)
                movieDatabase.movieDao().insertOnlySingleMovie(myMovie)//todo one movie here

                Log.v("insertToRoom",it.title)
//                insertGenresToRoom(title,List<Genres>)
                }
//        }

    }

}
//we use this class to parse the json to seperate movies:
//class movie(val title:String,val image:String,val rating:Double,val releaseYear:Int,val genre:List<String>)

@Entity(tableName = "movie_table")
data class mov(
        @PrimaryKey @ColumnInfo(name="title") val title: String,
        @ColumnInfo val image: String,
        @ColumnInfo val rating: Double,
        @ColumnInfo val releaseYear: Int
)

