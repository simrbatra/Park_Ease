package com.example.park_ease

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NotificationAdapter(
    private val context: Context,
    private val data: List<NotificationModel>
) : BaseAdapter() {

    override fun getCount() = data.size

    override fun getItem(position: Int) = data[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false)

        val model = data[position]

        val title = view.findViewById<TextView>(R.id.tvTitle)
        val message = view.findViewById<TextView>(R.id.tvMessage)
        val time = view.findViewById<TextView>(R.id.tvTime)
        val indicator = view.findViewById<View>(R.id.sideIndicator)

        title.text = model.title
        message.text = model.message
        time.text = model.time
        indicator.visibility = if (model.isActive) View.VISIBLE else View.GONE

        return view
    }
}
