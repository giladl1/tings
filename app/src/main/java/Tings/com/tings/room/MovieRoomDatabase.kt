package Tings.com.tings.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Movie class
@Database(entities = arrayOf(Movie::class), version = 2)
public abstract class MovieRoomDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    private class MovieDatabaseCallback(
            private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.movieDao())
                }
            }
        }

        suspend fun populateDatabase(movieDao: MovieDao) {
            // Delete all content here.
//            movieDao.deleteAll()

            // Add sample movies.
//            var movie = Movie("Hello")
//            movieDao.insert(movie)
//            movie = Movie("World!")
//            movieDao.insert(movie)

            // TODO: Add your own movies!
        }
    }
    
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): MovieRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieRoomDatabase::class.java,
                        "movie_database"
                ).addCallback(MovieDatabaseCallback(scope))
                 .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}