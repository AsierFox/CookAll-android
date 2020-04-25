package com.devdream.cookall.modules.recipe

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.format.DateUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RemoteViews
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devdream.cookall.common.dto.RecipeDTO
import com.devdream.cookall.context.AppContext
import com.example.cookall.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class RecipeListMainActivity : AppCompatActivity(), RecipeListMainContract.OnListFragmentInteractionListener {

    lateinit var bottomNavigationView: BottomNavigationView

//    var favoriteRecipesFragment: FavoriteRecipesFragment? = null
//    var exploreRecipesFragment: ExploreRecipesFragment? = null
//    var myRecipesFragment: MyRecipesFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list_main)

        disableBackButton()

//        favoriteRecipesFragment = FavoriteRecipesFragment()
//        exploreRecipesFragment = ExploreRecipesFragment()
//        myRecipesFragment = MyRecipesFragment()

        bottomNavigationView = findViewById<View>(R.id.bottom_navigation_recipe_list) as BottomNavigationView

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_recipe_list_main) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_recipe_list_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.test_simple_notification -> {

                val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val notificationBuilder: NotificationCompat.Builder = NotificationCompat
                    .Builder(AppContext.applicationContext(), "test_id")
                    .apply {
                        setSmallIcon(R.drawable.app_logo)
                        setContentTitle("Simple notification")
                        setCustomContentView(RemoteViews(packageName, R.layout.notification_simple_recipe))
                        priority = NotificationCompat.PRIORITY_DEFAULT
                    }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    val channelId = "Your_channel_id"
                    val channel = NotificationChannel(
                        channelId,
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_HIGH
                    )

                    notificationManager.createNotificationChannel(channel)
                    notificationBuilder.setChannelId(channelId)
                }

                notificationManager.notify(0, notificationBuilder.build())

                true
            }
            R.id.test_expandable_notification ->  {

                val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val notificationBuilder: NotificationCompat.Builder = NotificationCompat
                    .Builder(AppContext.applicationContext(), "test_id")
                    .apply {
                        setSmallIcon(R.drawable.app_logo)
                        setContentTitle("Simple notification")
                        priority = NotificationCompat.PRIORITY_DEFAULT
                    }

                val expandedView = RemoteViews(packageName, R.layout.notification_expandable_recipe)

                expandedView.setImageViewResource(R.id.big_icon, R.drawable.app_logo)
                expandedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME))
                expandedView.setTextViewText(R.id.notification_message, "Test")

                notificationBuilder.setCustomBigContentView(expandedView)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    val channelId = "Your_channel_id"
                    val channel = NotificationChannel(
                        channelId,
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_HIGH
                    )

                    notificationManager.createNotificationChannel(channel)
                    notificationBuilder.setChannelId(channelId)
                }

                notificationManager.notify(0, notificationBuilder.build())

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onListFragmentInteraction(item: RecipeDTO) {
//        val intent = Intent(this, RecipeDetailActivity::class.java)
//        startActivity(intent)
//    }
//
//    override fun onFragmentInteraction(uri: Uri) {}

    private fun disableBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun logout(item: MenuItem) {
//        startActivity(Intent(this, LoginActivity::class.java))
//        finish()
    }

    fun test(item: MenuItem) {
//        startActivity(Intent(this, TestActivity::class.java))
    }

    fun navigateFeedback(item: MenuItem) {
//        startActivity(Intent(this, FeedbackActivity::class.java))
    }

    override fun onListFragmentInteraction(item: RecipeDTO?) {
        Toast.makeText(AppContext.applicationContext(), "CLICKED!", Toast.LENGTH_LONG).show()
    }

}
