package Tings.com.tings.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Tings.com.tings.json.mov;

/**
 * Created by giladl1 on 5/13/2018.
 */

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleMovie(mov myMov);
    //Movies
    @Insert
    void insertMultipleMovies(List<mov> MoviesList);

//    @Query("SELECT * FROM  mov WHERE title = :movieTitle")
//    Movies fetchOneMoviesbyMovieTitle(String movieTitle);
//
//    @Query("SELECT * FROM mov ORDER BY title DESC ")
//    List<mov> getMovies();

    @Update
    void updateMovie(mov movies);
    @Delete
    void deleteMovie(mov movies);
}
