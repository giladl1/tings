package Tings.com.tings.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * from movie_table ORDER BY movie ASC")
    fun getAllMovies():  LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAll()
}