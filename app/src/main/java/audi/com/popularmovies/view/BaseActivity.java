package audi.com.popularmovies.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import audi.com.popularmovies.R;

/**
 * Created by Audi on 14/09/16.
 */
abstract public class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    protected void setUpToolBar(String title) {
        toolbar = setUpToolBar(R.id.toolbar, title);
    }

    //Use this if you have a different id
    private Toolbar setUpToolBar(int id, String title) {
        toolbar = (Toolbar) findViewById(id);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        return toolbar;
    }
}
