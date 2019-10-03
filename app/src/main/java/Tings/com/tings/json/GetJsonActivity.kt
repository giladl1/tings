package Tings.com.tings.json

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import Tings.com.tings.R
import android.graphics.Movie
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import kotlinx.android.synthetic.main.activity_get_json.*

class GetJsonActivity : AppCompatActivity() {
    lateinit var URL:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_json)
        setSupportActionBar(toolbar)
        URL ="http://api.androidhive.info/json/movies.json"
        stam()
//        sampleKo()


    }
    private fun stam(){
        val avi:String="avi"
    }
    private fun sampleKo() {
        //https://github.com/androidmads/KotlinFuelHttpSample/blob/master/app/src/main/java/com/androidmads/kotlinfuelhttpsample/MainActivity.kt
        //https://github.com/kittinunf/Fuel/blob/1.16.0/README.md
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
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(MoviesJson::class.java)
        val movie = jsonAdapter.fromJson(json)
        println(movie)
    }

}
