package Tings.com.tings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_get_json.*
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_specific_movie.*
import kotlinx.android.synthetic.main.recyclerview_item_row2.*

class SpecificPurchaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_movie)


        setSupportActionBar(toolbar1)
        var title:String= intent.getStringExtra("title")
        val image:String = intent.getStringExtra("image")
        val rating:String = intent.getStringExtra("rating")
        val releaseYear:String = intent.getStringExtra("releaseYear")

//        val genre0:String = intent.getStringExtra("genre0")
//        val genre1:String = intent.getStringExtra("genre1")
//        val genre2:String = intent.getStringExtra("genre2")


        titleTextView2.text="title: " + title
        ratingTextView2.text="rating: " + rating
        releaseYearTextView2.text="release year: " + releaseYear

        Glide.with(this)
                .load(image)
                .into(imageView2)
    }


}
