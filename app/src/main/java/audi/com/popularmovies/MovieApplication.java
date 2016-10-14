package audi.com.popularmovies;

import android.app.Application;

import audi.com.popularmovies.model.database.greenbot.DaoSession;
import audi.com.popularmovies.utils.DBHelper;

/**
 * Created by Audi on 15/10/16.
 */

public class MovieApplication extends Application {

    private DBHelper mDbHelper;
    private static MovieApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mDbHelper = new DBHelper(mInstance);

    }

    public static MovieApplication getInstance() {
        return mInstance;
    }

    public static DaoSession getNewSession() {
        return getInstance().mDbHelper.getSession(true);
    }

    public static DaoSession getSession() {
        return getInstance().mDbHelper.getSession(false);
    }
}
