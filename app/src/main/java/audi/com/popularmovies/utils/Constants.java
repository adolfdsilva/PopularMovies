package audi.com.popularmovies.utils;

import android.util.Log;

/**
 * Created by Audi on 15/09/16.
 */
public class Constants {

    private static final String DOMAIN = "http://api.themoviedb.org/";
    private static final String API_URL = DOMAIN + "3/";

    private static final String MOVIES = API_URL + "movie/";
    public static final String POP_MOVIES = MOVIES + "popular";
    public static final String IMG_URL = "http://image.tmdb.org/t/p/" + "w185";
    public static final String TOP_MOVIES = MOVIES + "top_rated";

    public static final String TAG = "PopularMovies";



    //Volley Constants
    public static final int REQUEST_TIMEOUT = 60000;
    public static final float BACKOFF_MULT = 1;
    public static final int MAX_RETRIES = 1;

    //Volley Errors
    public static final String NO_INTERNET_CONNECTION = "No Internet Connection";
    public static final String SERVER_ERROR = "Server Error";
    public static final String NETWORK_ERROR = "Network Error";
    public static final String CONNECTION_TIME_OUT = "Connection Timeout";

    //Server Errors
    public static final String NO_MORE_RESULTS = "no results found";



    public static void debug(String msg) {
        Log.d(TAG, "" + msg);
    }

    public static void info(String msg) {
        Log.i(TAG, "" + msg);
    }

    public static void error(String msg) {
        Log.e(TAG, "" + msg);
    }

    public static void warning(String msg) {
        Log.w(TAG, "" + msg);
    }


}
