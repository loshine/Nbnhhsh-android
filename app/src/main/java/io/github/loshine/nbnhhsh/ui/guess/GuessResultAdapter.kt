package io.github.loshine.nbnhhsh.ui.guess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.loshine.nbnhhsh.R
import kotlinx.android.synthetic.main.recycler_item_guess_result.view.*
import javax.inject.Inject

class GuessResultAdapter @Inject constructor(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_guess_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.text.text = data[position]
    }

    override fun getItemCount() = data.size

    fun setNewData(newData: Collection<String>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}