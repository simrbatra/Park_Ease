package com.example.park_ease


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.park_ease.databinding.BottomSheetSortBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SortBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetSortBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example click listeners for the checkboxes
        binding.checkboxDistance.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Trigger sorting by distance
                val filterBottomSheet = FilterBottomSheet()
                filterBottomSheet.show(parentFragmentManager, "FilterBottomSheet")

            }

        }

        binding.checkboxSlots.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Trigger sorting by slots
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
