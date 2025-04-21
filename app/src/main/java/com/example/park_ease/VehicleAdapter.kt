package com.example.park_ease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.park_ease.R

class VehicleAdapter(
    private var vehicles: List<Vehicle>,
    private val onVehicleSelected: (Vehicle) -> Unit
) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    inner class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconCar: ImageView = itemView.findViewById(R.id.iconCar)
        val nameText: TextView = itemView.findViewById(R.id.vehicleName)
        val plateText: TextView = itemView.findViewById(R.id.vehiclePlate)
        val checkIcon: ImageView = itemView.findViewById(R.id.checkIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vehicle_card, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holder.nameText.text = vehicle.name
        holder.plateText.text = vehicle.plateNumber

        holder.checkIcon.visibility = if (vehicle.isSelected) View.VISIBLE else View.INVISIBLE
        holder.itemView.setBackgroundResource(
            if (vehicle.isSelected) R.drawable.bg_card_selected else R.drawable.bg_card_white
        )

        holder.itemView.setOnClickListener {
            vehicles = vehicles.mapIndexed { index, v ->
                v.copy(isSelected = index == position)
            }
            notifyDataSetChanged()
            onVehicleSelected(vehicle)
        }
    }

    override fun getItemCount(): Int = vehicles.size
}