package com.devdream.cookall.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.devdream.cookall.R;

public class MainActivity extends AppCompatActivity {

    private BottomMenuSelectedListener bottomMenuSelectedListener;

    private boolean hasActionBar;

    protected TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasActionBar = getSupportActionBar() != null;


        disableBackButton();

        mTextMessage = (TextView) findViewById(R.id.message);

        bottomMenuSelectedListener = new BottomMenuSelectedListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(bottomMenuSelectedListener);
    }

    private void disableBackButton() {
        if (hasActionBar) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

}
