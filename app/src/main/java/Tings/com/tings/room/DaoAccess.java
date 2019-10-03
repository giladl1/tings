package room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by giladl1 on 5/13/2018.
 */

//@Dao
//public interface DaoAccess {
//
//    @Insert
//    void insertOnlySingleMovie (Movies movies);
//    @Insert
//    void insertMultipleMovies (List<Movies> moviesList);
//    @Query("SELECT * FROM Movies WHERE movieId = :movieId")
//    Movies fetchOneMoviesbyMovieId (int movieId);
//    @Update
//    void updateMovie (Movies movies);
//    @Delete
//    void deleteMovie (Movies movies);
//}
@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleSample (Samples Samples);
    @Insert
    void insertMultipleSamples (List<Samples> SamplesList);
    @Query("SELECT * FROM Samples WHERE sampleId = :sampleId")
    Samples fetchOneSamplesbySampleId (int sampleId);
    @Query("SELECT * FROM Samples ORDER BY sampleId DESC ")
    public List<Samples> getSamples();
    @Update
    void updateSample (Samples samples);
    @Delete
    void deleteSample (Samples samples);
}
