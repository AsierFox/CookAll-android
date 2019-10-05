package com.devdream.cookall.test

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.text.format.DateUtils
import android.view.View
import android.widget.RemoteViews

import com.devdream.cookall.R
import com.devdream.cookall.chat.ChatActivity

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    fun testSimpleNotification(view: View) {
        //When the user clicks the button this intent will trigger
        val intent = Intent(this, TestActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this@TestActivity, 0, intent, 0)

        // Create a notification
        val builder = NotificationCompat.Builder(this)

        // Setting small icon for our notification
        builder.setSmallIcon(R.drawable.app_logo)
        builder.setContentTitle("My notification")
        builder.setContentText("Description of the notification")

        // ATTACHING PENDING INTENT TO NOTIFICATION
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        // And finally NotificationManager for the notify the user!
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val NOTIFICATION_ID = 1
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun testCustomNotification(view: View) {
        val intent = Intent(this, TestActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this@TestActivity, 0, intent, 0)

        val collapsedView = RemoteViews(packageName, R.layout.notification_custom_test)
        val expandedView = RemoteViews(packageName, R.layout.notification_custom_test_expanded)

        expandedView.setImageViewResource(R.id.big_icon, R.drawable.app_logo)
        expandedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME))
        expandedView.setTextViewText(R.id.notification_message, "Test")

        collapsedView.setImageViewResource(R.id.big_icon, R.drawable.app_logo)
        collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME))

        // adding action to left button
        val leftIntent = Intent(this, NotificationIntentService::class.java)
        leftIntent.action = "left"
        expandedView.setOnClickPendingIntent(R.id.left_button, PendingIntent.getService(this, 0, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT))

        // adding action to right button
        val rightIntent = Intent(this, NotificationIntentService::class.java)
        rightIntent.action = "right"
        expandedView.setOnClickPendingIntent(R.id.right_button, PendingIntent.getService(this, 1, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT))

        val builder = NotificationCompat.Builder(this)
                // these are the three things a NotificationCompat.Builder object requires at a minimum
                .setSmallIcon(R.drawable.app_logo)
                .setContentTitle("Test")
                .setContentText("test")
                // notification will be dismissed when tapped
                .setAutoCancel(true)
                // tapping notification will open MainActivity
                .setContentIntent(PendingIntent.getActivity(this, 0, Intent(this, TestActivity::class.java), 0))
                // setting the custom collapsed and expanded views
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                // setting style to DecoratedCustomViewStyle() is necessary for custom views to display
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val NOTIFICATION_ID = 2
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun navigateChat(view: View) {
        startActivity(Intent(this, ChatActivity::class.java))
        finish()
    }

}
