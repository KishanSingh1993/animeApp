package com.kishan.animeapp.ui.anime_detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kishan.animeapp.databinding.FragmentAnimeDetailBinding

class AnimeDetailFragment : Fragment() {

    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AnimeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animeId = arguments?.getInt("animeId") ?: return
        viewModel = ViewModelProvider(this)[AnimeDetailViewModel::class.java]

        viewModel.getAnimeDetails(animeId).observe(viewLifecycleOwner) { anime ->
            binding.animeTitle.text = anime.title
            binding.animeSynopsis.text = anime.synopsis ?: "No synopsis available"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
