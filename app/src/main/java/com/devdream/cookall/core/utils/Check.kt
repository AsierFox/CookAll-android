package com.devdream.cookall.core.utils

import android.preference.PreferenceFragment

import com.devdream.cookall.settings.fragments.DataSyncPreferenceFragment
import com.devdream.cookall.settings.SettingsActivity
import com.devdream.cookall.settings.fragments.GeneralPreferenceFragment
import com.devdream.cookall.settings.fragments.NotificationPreferenceFragment

object Check {

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    fun isValidFragment(fragmentName: String): Boolean {
        return (PreferenceFragment::class.java.name == fragmentName
                || GeneralPreferenceFragment::class.java.name == fragmentName
                || DataSyncPreferenceFragment::class.java.name == fragmentName
                || NotificationPreferenceFragment::class.java.name == fragmentName)
    }

}
