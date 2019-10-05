package Tings.com.tings

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_my_purchases.*
import layout.RecyclerAdapter
//import Tings.com.tings.firebaseClasses.Payment
import Tings.com.tings.json.mov
import Tings.com.tings.room.*
import android.content.*
import android.os.AsyncTask
import androidx.room.Room
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//import com.squareup.moshi.Moshi
//import com.google.gson.annotations.JsonAdapter
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory

import android.os.Handler
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_get_json.*
import kotlinx.coroutines.*
import java.lang.Runnable


class MyPurchasesActivity : AppCompatActivity() {
    val MY_PERMISSIONS_REQUEST_INTERNET=1
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dataset: Array<String>
    private lateinit var list : MutableList<String>
    private lateinit var paymentIds : MutableList<String>
//    private lateinit var paymentList : MutableList<Payment>
    lateinit var URL:String
    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable

    var myService: GetMoviesService? = null
    var isBound = false
//    var movieDatabase: MovieDatabase? = null
    val db = FirebaseFirestore.getInstance()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_purchases)
        setSupportActionBar(toolbar1)

        URL ="http://api.androidhive.info/json/movies.json"
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            askPermission()
        }
        else askPermission();






        var movieDatabase:MovieRoomDatabase=
                Room.databaseBuilder(this,
                        MovieRoomDatabase::class.java, "movies")
                        .fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build()
        var data= mutableListOf<Movie>()

        GlobalScope.launch {
            //            Movies m
//            movieDatabase.daoAccess().insertOnlySingleMovie()
            data = movieDatabase.movieDao().getAllMovies()

            data?.forEach {
                println(it)
            }
            operateAdapter( data)
        }


//        val someTask3 = someTask(this).execute()
//        val intent = Intent(this, GetMoviesService::class.java)
//        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)

        //$$$$$$$$$$$$$$$$$$$$$$$$$$

        sampleKo()
//        create()
//        getFromJson()
        // Initialize the handler instance
//        mHandler = Handler()


//        val intent = Intent(this, MyInsertService::class.java)
//        startService(intent)

//        insertMovieToRoom()
//        getMovieFromRoom()



    }

    override fun onStart() {
        super.onStart()

    }
    fun askPermission(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.INTERNET)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.INTERNET),
                        MY_PERMISSIONS_REQUEST_INTERNET)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

    }
//    fun getPurchasesFromFirebase(){
//
//        db.collection("payments")
//                .get()
//                .addOnSuccessListener { result ->
//
//                    for (document in result) {
//                        var payment : Payment=document.toObject(Payment::class.java)
//
//                        paymentList.add(payment)
//                        paymentIds.add(document.id)//we need the document id to change the id in the recyclerview
//                        list.add(document.data.toString())
////                        dataset[i]=(document.data.toString())
//                        Log.d("TAG", "${document.id} => ${document.data}")
//                    }
//                    dataset=list.toTypedArray()
//                    operateAdapter()
//                }
//                .addOnFailureListener { exception ->
//                    Log.d("TAG", "Error getting documents: ", exception)
//                }
//    }
    private fun initDataset() {
//        dataset = Array(60, {i -> "This is element # $i"})
        list= arrayListOf()
//        paymentList= arrayListOf()
        paymentIds = arrayListOf()
    }
//    private val broadcastReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            operateAdapter(intent)
//        }
//    }

    fun operateAdapter(movies:MutableList<Movie>){

        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerAdapter(movies)//, paymentIds )//dataset

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }


    }



    fun getMoviesFromRoom(){



                var movieDatabase: MovieRoomDatabase? = Room.databaseBuilder(applicationContext,
                        MovieRoomDatabase::class.java, "DATABASE_NAME")
                        .fallbackToDestructiveMigration()
                        .build()

                val movies = movieDatabase!!.movieDao().getAllMovies()
                operateAdapter(movies)
            // Schedule the task to repeat after 1 second



    }
    private fun sampleKo() {
        //https://github.com/androidmads/KotlinFuelHttpSample/blob/master/app/src/main/java/com/androidmads/kotlinfuelhttpsample/MainActivity.kt
        //https://github.com/kittinunf/Fuel/blob/1.16.0/README.md
        try {

            Fuel.post(URL, listOf()).responseJson { request, response, result ->
                Log.d("plzzzzz", result.get().content)
//                onTaskCompleted(result.get().content)
            }
        } catch (e: Exception) {

        } finally {

        }
    }

//    private fun onTaskCompleted(json: String) {
//        println(json)
//        val moshi = Moshi.Builder().build()
//        val jsonAdapter = moshi.adapter(MoviesJson::class.java)
//        val movie = jsonAdapter.fromJson(json)
//        println(movie)
//    }
    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            val binder = service as GetMoviesService.MyLocalBinder
            myService = binder.getService()
            isBound = true
            val currentTime = myService?.getCurrentTime()
            val movies =myService?.getMovies()
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }
    private fun getMovieFromRoom(){
//        var movie: MutableList<Movies>? = movieDatabase?.daoAccess()?.getMovies()
    }
//    private fun getFromJson(){
//        val json = URL("http://api.androidhive.info/json/movies.json").readText()
//        val moshi = Moshi.Builder().build()
//        val jsonAdapter = moshi.adapter(Movies::class.java)
//        val movie = jsonAdapter.fromJson(json)
//        println(movie)
//    }



}
class someTask(val context: Context) : AsyncTask<Void, Void, String>() {

    var activity: MyPurchasesActivity= MyPurchasesActivity()
    lateinit var movies:MutableList<Movie>
//    lateinit var movieDatabase:MovieDatabase
    override fun doInBackground(vararg params: Void?): String? {

//        var movieDatabase:MovieDatabase =
//        val movies2:MutableList<Movies> = activity.movieDatabase!!.daoAccess().getMovies()
        return null
    }

    override fun onPreExecute() {
        super.onPreExecute()


        // ...
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        activity.operateAdapter(movies)
        // ...
    }
}


