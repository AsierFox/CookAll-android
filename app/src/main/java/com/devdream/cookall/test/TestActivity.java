package com.devdream.cookall.test;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.RemoteViews;

import com.devdream.cookall.R;
import com.devdream.cookall.chat.ChatActivity;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void testSimpleNotification(View view) {
        //When the user clicks the button this intent will trigger
        Intent intent = new Intent(this, TestActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(TestActivity.this, 0, intent, 0);

        // Create a notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Setting small icon for our notification
        builder.setSmallIcon(R.drawable.app_logo);
        builder.setContentTitle("My notification");
        builder.setContentText("Description of the notification");

        // ATTACHING PENDING INTENT TO NOTIFICATION
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);

        // And finally NotificationManager for the notify the user!
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 1;
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void testCustomNotification(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(TestActivity.this, 0, intent, 0);

        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.notification_custom_test);
        RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.notification_custom_test_expanded);

        expandedView.setImageViewResource(R.id.big_icon, R.drawable.app_logo);
        expandedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
        expandedView.setTextViewText(R.id.notification_message, "Test");

        collapsedView.setImageViewResource(R.id.big_icon, R.drawable.app_logo);
        collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));

        // adding action to left button
        Intent leftIntent = new Intent(this, NotificationIntentService.class);
        leftIntent.setAction("left");
        expandedView.setOnClickPendingIntent(R.id.left_button, PendingIntent.getService(this, 0, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT));

        // adding action to right button
        Intent rightIntent = new Intent(this, NotificationIntentService.class);
        rightIntent.setAction("right");
        expandedView.setOnClickPendingIntent(R.id.right_button, PendingIntent.getService(this, 1, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                // these are the three things a NotificationCompat.Builder object requires at a minimum
                .setSmallIcon(R.drawable.app_logo)
                .setContentTitle("Test")
                .setContentText("test")
                // notification will be dismissed when tapped
                .setAutoCancel(true)
                // tapping notification will open MainActivity
                .setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, TestActivity.class), 0))
                // setting the custom collapsed and expanded views
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                // setting style to DecoratedCustomViewStyle() is necessary for custom views to display
                .setStyle(new android.support.v7.app.NotificationCompat.DecoratedCustomViewStyle());

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 2;
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void navigateChat(View view) {
        startActivity(new Intent(this, ChatActivity.class));
        finish();
    }

}
