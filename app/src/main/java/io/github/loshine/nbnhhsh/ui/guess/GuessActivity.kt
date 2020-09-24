package io.github.loshine.nbnhhsh.ui.guess

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.loshine.nbnhhsh.R
import kotlinx.android.synthetic.main.activity_guess.*
import javax.inject.Inject

@AndroidEntryPoint
class GuessActivity : AppCompatActivity(R.layout.activity_guess) {

    private val viewModel: GuessViewModel by viewModels()

    @Inject
    lateinit var adapter: GuessResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        val text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT) ?: ""
        viewModel.guess(text.toString())

        viewModel.data.observe(this) { adapter.setNewData(it) }
        viewModel.loading.observe(this) {
            refresh_layout.isRefreshing = it
            if (!it) {
                refresh_layout.isEnabled = false
            }
        }
    }
}