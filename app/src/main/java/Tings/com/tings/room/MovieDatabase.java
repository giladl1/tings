package Tings.com.tings.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by giladl1 on 5/13/2018.
 */

//public class SampleDatabase {
//}
@Database(entities = {Movies.class}, version = 3, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
