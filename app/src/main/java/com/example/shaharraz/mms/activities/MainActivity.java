package com.example.shaharraz.mms.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.shaharraz.mms.R;
import com.example.shaharraz.mms.fragment.MovieListFragment;


public class MainActivity extends AppCompatActivity {
    private Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(myToolbar);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new MovieListFragment(), MovieListFragment.TAG)
                    .commitAllowingStateLoss();


        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        myToolbar.setTitle(R.string.app_name);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.colorGrey));
    }
}
