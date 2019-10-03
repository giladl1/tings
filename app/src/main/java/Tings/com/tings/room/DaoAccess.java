package Tings.com.tings.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by giladl1 on 5/13/2018.
 */

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleMovie(Movies Movies);

    @Insert
    void insertMultipleMovies(List<Movies> MoviesList);

    @Query("SELECT * FROM Movies WHERE title = :movieTitle")
    Movies fetchOneMoviesbyMovieTitle(String movieTitle);

    @Query("SELECT * FROM Movies ORDER BY title DESC ")
    List<Movies> getMovies();

    @Update
    void updateMovie(Movies movies);
    @Delete
    void deleteMovie(Movies movies);
}
