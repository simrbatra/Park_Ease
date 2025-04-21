package com.example.park_ease



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.park_ease.ResultAdapter
import com.example.park_ease.R


class ResultAdapter(private val items: List<ResultItem>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iconParking)
        val title: TextView = itemView.findViewById(R.id.titleText)
        val address: TextView = itemView.findViewById(R.id.addressText)
        val distance: TextView = itemView.findViewById(R.id.distanceText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.address.text = item.address
        holder.distance.text = item.distance
    }

    override fun getItemCount(): Int = items.size
}
