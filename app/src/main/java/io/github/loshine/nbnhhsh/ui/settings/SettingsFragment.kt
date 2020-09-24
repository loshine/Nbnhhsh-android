package io.github.loshine.nbnhhsh.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import dagger.hilt.android.AndroidEntryPoint
import io.github.loshine.nbnhhsh.R

@AndroidEntryPoint
class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}