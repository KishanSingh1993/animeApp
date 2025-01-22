package com.kishan.animeapp.ui.anime_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kishan.animeapp.R
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.databinding.FragmentAnimeListBinding

class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AnimeListViewModel
    private lateinit var adapter: AnimeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[AnimeListViewModel::class.java]


        adapter = AnimeListAdapter(emptyList()) { anime: Anime ->
            val bundle = Bundle().apply {
                putInt("animeId", anime.mal_id)
            }
            findNavController().navigate(R.id.animeDetailFragment, bundle)
        }

        binding.recyclerView.adapter = adapter

        viewModel.getAnimeList().observe(viewLifecycleOwner) { animeList ->
            adapter.updateList(animeList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null  // Prevent memory leaks
    }
}
