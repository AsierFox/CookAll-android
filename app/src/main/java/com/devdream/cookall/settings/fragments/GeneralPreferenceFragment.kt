package com.devdream.cookall.settings.fragments

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceFragment
import android.view.MenuItem

import com.devdream.cookall.R
import com.devdream.cookall.settings.SettingsActivity

class GeneralPreferenceFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref_general)
        setHasOptionsMenu(true)

        // Bind the summaries of EditText/List/Dialog/Ringtone preferences
        // to their values. When their values change, their summaries are
        // updated to reflect the new value, per the Android Design
        // guidelines.
        //bindPreferenceSummaryToValue(findPreference("example_text"));
        //bindPreferenceSummaryToValue(findPreference("example_list"));
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            startActivity(Intent(activity, SettingsActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
