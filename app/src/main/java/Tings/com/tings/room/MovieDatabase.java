package Tings.com.tings.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by giladl1 on 5/13/2018.
 */

//public class SampleDatabase {
//}
@Database(entities = {Samples.class}, version = 3, exportSchema = false)
public abstract class SampleDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
