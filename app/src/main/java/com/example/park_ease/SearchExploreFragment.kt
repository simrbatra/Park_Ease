package com.example.park_ease

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.park_ease.databinding.FragmentSearchExploreBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager


class SearchExploreFragment : Fragment() {

    private lateinit var binding: FragmentSearchExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Nearby Data
        val nearbyList = listOf(
            NearbyItem("Park Rangeride", "29 slots available", "500 m"),
            NearbyItem("Mount Wheathe", "10 slots available", "750 m"),
            NearbyItem("Daypark Bay", "23 slots available", "1 km")
        )

        val nearbyAdapter = NearbyAdapter(nearbyList)
        binding.nearbyRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.nearbyRecyclerView.adapter = nearbyAdapter

        // Explore Data
        val exploreList = listOf(
            ExploreItem(R.drawable.explore_sport, "Sport"),
            ExploreItem(R.drawable.explore_business, "Business")
        )

        val exploreAdapter = ExploreAdapter(exploreList)
        binding.exploreRecyclerView.layoutManager =
            GridLayoutManager(context, 2)
        binding.exploreRecyclerView.adapter = exploreAdapter
    }
}
