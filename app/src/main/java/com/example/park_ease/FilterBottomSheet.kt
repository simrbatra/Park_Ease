package com.example.park_ease



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.park_ease.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider
import com.google.android.material.switchmaterial.SwitchMaterial
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FilterBottomSheet : BottomSheetDialogFragment() {

    private lateinit var distanceSlider: Slider
    private lateinit var distanceValue: TextView
    private lateinit var valetSwitch: SwitchMaterial
    private lateinit var applyButton: Button

    private var selectedDistance = 9
    private var isValetEnabled = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_filter_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        distanceSlider = view.findViewById(R.id.distanceSlider)
        distanceValue = view.findViewById(R.id.distanceValue)
        valetSwitch = view.findViewById(R.id.valetSwitch)
        applyButton = view.findViewById(R.id.applyFilterButton)

        // Initial value
        distanceValue.text = "${distanceSlider.value.toInt()} km"

        // Slider value change listener
        distanceSlider.addOnChangeListener { _, value, _ ->
            selectedDistance = value.toInt()
            distanceValue.text = "$selectedDistance km"
        }

        // Switch toggle listener
        valetSwitch.setOnCheckedChangeListener { _, isChecked ->
            isValetEnabled = isChecked
        }

        // Button click
        applyButton.setOnClickListener {
            // You can use callback/interface to send data back if needed
            Toast.makeText(
                requireContext(),
                "Distance: $selectedDistance km\nValet: $isValetEnabled",
                Toast.LENGTH_SHORT
            ).show()

            dismiss()
        }
    }
}
