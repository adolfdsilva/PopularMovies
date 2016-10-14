package audi.com.popularmovies.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import audi.com.popularmovies.MovieApplication;
import audi.com.popularmovies.model.database.greenbot.DaoMaster;
import audi.com.popularmovies.model.database.greenbot.DaoSession;


/**
 * Created by User-PC on 11-08-2015.
 */
public class DBHelper {
    private Context mContext;
    private String dataPath = "";

    private SQLiteDatabase mDb = null;
    private DaoSession mSession = null;

    public DBHelper(MovieApplication application) {
        this(application, "");
    }

    public DBHelper(MovieApplication application, String dataPath) {
        mContext = application;
        this.dataPath = dataPath;
    }

    private DaoMaster getMaster() {
        if (mDb == null) {
            mDb = getDatabase(Constants.DB_NAME, false);
        }
        return new DaoMaster(mDb);
    }

    public DaoSession getSession(boolean newSession) {
        if (newSession) {
            return getMaster().newSession();
        }
        if (mSession == null) {
            mSession = getMaster().newSession();
        }
        return mSession;
    }

    private synchronized SQLiteDatabase getDatabase(String name, boolean readOnly) {
        try {
            if (readOnly) {
                Constants.info("getDB(" + name + ",readonly=true)");
            } else {
                Constants.info("getDB(" + name + ",readonly=false)");
            }
            SQLiteOpenHelper helper = new MyOpenHelper(mContext, dataPath, name, null);
            if (readOnly) {
                return helper.getReadableDatabase();
            } else {
                return helper.getWritableDatabase();
            }
        } catch (Exception ex) {
            if (readOnly) {
                Constants.error("getDB(" + name + ",readonly=true)");
            } else {
                Constants.error("getDB(" + name + ",readonly=false)");
            }
            return null;
        } catch (Error err) {
            if (readOnly) {
                Constants.error("getDB(" + name + ",readonly=true)");
            } else {
                Constants.error("getDB(" + name + ",readonly=false)");
            }
            return null;
        }
    }

    private class MyOpenHelper extends DaoMaster.OpenHelper {
        public MyOpenHelper(Context context, String dataPath, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, concatPath(dataPath, name), factory);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Constants.info("Create DB-Schema (version " + Integer.toString(DaoMaster.SCHEMA_VERSION) + ")");
            super.onCreate(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Constants.info("Update DB-Schema to version: " + Integer.toString(oldVersion) + "->" + Integer.toString(newVersion));
        }
    }

    private String concatPath(String path, String name) {
        return path + name;
    }
}
