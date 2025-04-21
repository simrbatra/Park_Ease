package com.example.park_ease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.park_ease.databinding.FragmentBusinessDetailBinding

class BusinessDetailFragment : Fragment() {

    private lateinit var binding: FragmentBusinessDetailBinding
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var nearbyAdapter: NearbyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBusinessDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupPopularSection()
        setupNearbySection()

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupPopularSection() {
        val items = listOf(
            ExploreItem(R.drawable.explore_building1, "Busipark"),
            ExploreItem(R.drawable.explore_building2, "QWorkspace"),
            ExploreItem(R.drawable.explore_building3, "ModernPark")
        )
        popularAdapter = PopularAdapter(items)
        binding.popularRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecyclerView.adapter = popularAdapter
    }

    private fun setupNearbySection() {
        val nearbyList = listOf(
            NearbyItem("Saltsburg Tower", "29 slots available", "1.5 km"),
            NearbyItem("Kinmundy", "10 slots available", "1.7 km"),
            NearbyItem("Northwest Hawwinton", "23 slots available", "2 km")
        )
        nearbyAdapter = NearbyAdapter(nearbyList)
        binding.nearbyRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.nearbyRecyclerView.adapter = nearbyAdapter
    }
}
