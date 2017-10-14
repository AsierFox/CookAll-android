package com.devdream.cookall.core.utils;

import android.preference.PreferenceFragment;

import com.devdream.cookall.settings.fragments.DataSyncPreferenceFragment;
import com.devdream.cookall.settings.SettingsActivity;
import com.devdream.cookall.settings.fragments.GeneralPreferenceFragment;
import com.devdream.cookall.settings.fragments.NotificationPreferenceFragment;

public abstract class Check {

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    public static boolean isValidFragment(String fragmentName) {
        return PreferenceFragment.class.getName().equals(fragmentName)
                || GeneralPreferenceFragment.class.getName().equals(fragmentName)
                || DataSyncPreferenceFragment.class.getName().equals(fragmentName)
                || NotificationPreferenceFragment.class.getName().equals(fragmentName);
    }

}
