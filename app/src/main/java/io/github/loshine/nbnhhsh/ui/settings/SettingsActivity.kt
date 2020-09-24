package io.github.loshine.nbnhhsh.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.loshine.nbnhhsh.R

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity(R.layout.activity_settings) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}