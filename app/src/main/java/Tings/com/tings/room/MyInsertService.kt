package Tings.com.tings.room

import android.app.IntentService
import android.content.Intent
import android.content.Context
import androidx.room.Room

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "Tings.com.tings.room.action.FOO"
private const val ACTION_BAZ = "Tings.com.tings.room.action.BAZ"

val DATABASE_NAME: String = "movies"
private var movieDatabase: MovieDatabase? = null

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "Tings.com.tings.room.extra.PARAM1"
private const val EXTRA_PARAM2 = "Tings.com.tings.room.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class MyInsertService : IntentService("MyInsertService") {

    override fun onHandleIntent(intent: Intent?) {
        movieDatabase = Room.databaseBuilder(this,
                MovieDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        var movie: Movies = Movies()
        movie.setTitle("211")
        movie.setImage("999")
        movie.setRating("777")
        movie.setRelaseYear("333")
//        val genreSet: Movies.Genre=Movies.Genre() Genre("0","drama")
//        val genreSet= arrayOf Movies.Genre("0","drama")

        movieDatabase!!.daoAccess().insertOnlySingleMovie(movie)
//        when (intent?.action) {
//            ACTION_FOO -> {
//                val param1 = intent.getStringExtra(EXTRA_PARAM1)
//                val param2 = intent.getStringExtra(EXTRA_PARAM2)
//                handleActionFoo(param1, param2)
//            }
//            ACTION_BAZ -> {
//                val param1 = intent.getStringExtra(EXTRA_PARAM1)
//                val param2 = intent.getStringExtra(EXTRA_PARAM2)
//                handleActionBaz(param1, param2)
//            }
//        }
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

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyInsertService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyInsertService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}
