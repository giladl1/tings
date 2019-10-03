package Tings.com.tings.room

import Tings.com.tings.MyPurchasesActivity
import Tings.com.tings.R
import android.app.IntentService
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import layout.RecyclerAdapter
import Tings.com.tings.room.ServiceCallbacks as ServiceCallbacks1





// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
//const val ACTION_FOO = "Tings.com.tings.room.action.FOO"
//const val ACTION_BAZ = "Tings.com.tings.room.action.BAZ"

// TODO: Rename parameters
//const val EXTRA_PARAM1 = "Tings.com.tings.room.extra.PARAM1"
//const val EXTRA_PARAM2 = "Tings.com.tings.room.extra.PARAM2"

val DATABASE_NAME2: String = "movies"
private var movieDatabase: MovieDatabase? = null

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions and extra parameters.
 */
class MySelectService() : IntentService("MySelectService") {

    override fun onHandleIntent(intent: Intent?) {
                movieDatabase = Room.databaseBuilder(applicationContext,
                        MovieDatabase::class.java, DATABASE_NAME2)
                        .fallbackToDestructiveMigration()
                        .build()
                val movies = movieDatabase!!.daoAccess().getMovies()//fetchOneMoviesbyMovieTitle("448")
//        var moviesInArr:List<Movies>=arrayListOf(movies)
//        val myServiceCallbacks:Tings.com.tings.room.ServiceCallbacks
//        val BROADCAST_ACTION = "com.mukesh.service"
//        val intent = Intent(BROADCAST_ACTION);
//        intent.putExtra("time", movies)
//        intent.putExtra("counter", String.valueOf(counter))
//        sendBroadcast(intent)
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }
}
