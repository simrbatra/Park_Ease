package com.example.park_ease



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.park_ease.R
import com.example.park_ease.databinding.LayoutParkingDetailBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.widget.Toast

class ParkingDetailBottomSheet : BottomSheetDialogFragment() {

    private var _binding: LayoutParkingDetailBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutParkingDetailBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set static or dynamic data
        binding.parkingTitle.text = "Parking Lot of Capital University"
        binding.parkingAddress.text = "1514 Robin St, Auburndale"
        binding.parkingRules.text = getString(R.string.sample_rules)

        // You can set images using Glide or Coil
        // Glide.with(this).load(imageUrl).into(binding.parkingImage)

        // Bookmark button click
        binding.bookmarkButton.setOnClickListener {
            Toast.makeText(context, "Bookmarked!", Toast.LENGTH_SHORT).show()
        }

        // Book parking button click
        binding.bookParkingButton.setOnClickListener {
            Toast.makeText(context, "Parking Booked!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
