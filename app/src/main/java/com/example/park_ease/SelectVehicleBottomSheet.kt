package com.example.park_ease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.park_ease.databinding.SelectVehicleBottomSheetBinding

class SelectVehicleBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: SelectVehicleBottomSheetBinding
    private lateinit var adapter: VehicleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SelectVehicleBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val vehicleList = listOf(
            Vehicle("2021 Audi Q3", "B 1234 CD", true),
            Vehicle("2021 BMW X2", "B 5632 DM"),
            Vehicle("Honda Scooter", "B 8877 SF")
        )

        adapter = VehicleAdapter(vehicleList) { selectedVehicle ->
            // Handle selected vehicle
        }

        binding.vehicleRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.vehicleRecyclerView.adapter = adapter
    }
}