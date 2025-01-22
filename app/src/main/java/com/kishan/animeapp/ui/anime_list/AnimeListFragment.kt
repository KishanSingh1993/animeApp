package com.kishan.animeapp.ui.anime_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kishan.animeapp.R
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.databinding.FragmentAnimeListBinding

class AnimeListFragment : Fragment(R.layout.fragment_anime_list) {
    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var viewModel: AnimeListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeListBinding.bind(view)
        viewModel = ViewModelProvider(this)[AnimeListViewModel::class.java]

        val adapter = AnimeListAdapter { anime ->
            // Navigate to details page
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.getAnimeList().observe(viewLifecycleOwner) { resource ->
            adapter.submitList(resource.data)
        }
    }

//    private fun navigateToDetails(anime: Anime) {
//        val action = AnimeListFragmentDirections
//            .actionAnimeListFragmentToAnimeDetailFragment(anime.mal_id)
//        findNavController().navigate(action)
//    }
}
