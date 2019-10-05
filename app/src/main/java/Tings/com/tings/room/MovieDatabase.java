package Tings.com.tings.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Tings.com.tings.json.mov;

/**
 * Created by giladl1 on 5/13/2018.
 */

//public class SampleDatabase {
//}
@Database(entities = {mov.class}, version = 3, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
