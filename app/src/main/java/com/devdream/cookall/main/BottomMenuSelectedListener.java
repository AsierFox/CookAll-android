package com.devdream.cookall.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.devdream.cookall.R;

public class BottomMenuSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MainActivity mainActivity;

    public BottomMenuSelectedListener(MainActivity _mainActivity) {
        mainActivity = _mainActivity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mainActivity.mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:
                mainActivity.mTextMessage.setText(R.string.title_dashboard);
                return true;
            case R.id.navigation_notifications:
                mainActivity.mTextMessage.setText(R.string.title_notifications);
                return true;
        }
        return false;
    }

}
