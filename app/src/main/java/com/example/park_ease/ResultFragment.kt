package com.example.park_ease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.park_ease.databinding.FragmentSearchResultBinding
import com.example.park_ease.ResultAdapter
import com.example.park_ease.ResultItem


class ResultFragment : Fragment() {

    private var _binding: FragmentSearchResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultItems = listOf(
            ResultItem("Capital University", "1514 Robin St, Auburndale", "4 km"),
            ResultItem("CU Hall", "1524 Robin St, Auburndale", "4.5 km"),
            ResultItem("CU Business Center", "1528 Robin St, Auburndale", "4.8 km"),
            ResultItem("CU Career", "1529 Robin St, Auburndale", "4.9 km"),
            ResultItem("CU Mart", "1530 Robin St, Auburndale", "5 km")
        )

        val adapter = ResultAdapter(resultItems)
        binding.resultRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.resultRecyclerView.adapter = adapter
        binding.filterIcon.setOnClickListener {
            val sortSheet = SortBottomSheetFragment()
            sortSheet.show(parentFragmentManager, "SortBottomSheet")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
