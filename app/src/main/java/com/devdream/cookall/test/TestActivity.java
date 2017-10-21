package com.devdream.cookall.test;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RemoteViews;

import com.devdream.cookall.R;

public class TestActivity extends AppCompatActivity {

    private CharSequence notificationTitleText = "Hello Title";
    private CharSequence notificationDescText = "This is custom Notification desc";

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

        // Inflating our custom layout by the RemoteViews class
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_custom_test);

        // Setting custom layout views properties
//        remoteViews.setImageViewResource(R.id.imageViewIcon, R.drawable.ic_liked_24dp);
        remoteViews.setTextViewText(R.id.textViewTitle, notificationTitleText);
        remoteViews.setTextViewText(R.id.textViewDesc, notificationDescText);

        // Create a notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Setting small icon for our notification
        builder.setSmallIcon(R.drawable.app_logo);

        // Attaching our notification
        builder.setContentTitle("My notification");
        builder.setContentText("Description of the notification");


        // ATTACHING PENDING INTENT TO NOTIFICATION
        builder.setContentIntent(pendingIntent);

        // And finally NotificationManager for the notify the user!
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 1;
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void testCustomNotification(View view) {
    }

}
