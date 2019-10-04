package Tings.com.tings

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_specific_purchase.*
import kotlinx.android.synthetic.main.content_specific_purchase.*

class SpecificPurchaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_purchase)


        setSupportActionBar(toolbar)
        var title:String= intent.getStringExtra("title")
        val image:String = intent.getStringExtra("image")
        val rating:String = intent.getStringExtra("rating")
        val releaseYear:String = intent.getStringExtra("releaseYear")

        val genre0:String = intent.getStringExtra("genre0")
        val genre1:String = intent.getStringExtra("genre1")
        val genre2:String = intent.getStringExtra("genre2")

        textViewTotalPrice.text="title: " + title
        textViewDate.text= "image: " +image
        textViewEndDate.text="rating: " + rating
        textViewBusiness.text="release year: " + releaseYear
        textViewPartner.text= "genres: " +genre0

    }


}
