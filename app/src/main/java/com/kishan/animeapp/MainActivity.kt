package com.kishan.animeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.databinding.ActivityAnimeDetailBinding
import com.kishan.animeapp.databinding.ActivityMainBinding
import com.kishan.animeapp.repository.AnimeRepository
import com.kishan.animeapp.util.RetrofitClient

class MainActivity : AppCompatActivity() {

    private val viewModel: AnimeViewModel by viewModels {
        AnimeViewModelFactory(AnimeRepository(RetrofitClient.api))
    }
    private lateinit var adapter: AnimeAdapter
    private lateinit var binding: ActivityMainBinding
    //private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = AnimeAdapter { anime -> navigateToDetail(anime) }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.animeList.observe(this) { animeList ->
            adapter.submitList(animeList)
        }

        viewModel.fetchTopAnime()
    }

    private fun navigateToDetail(anime: Anime) {
        val intent = Intent(this, AnimeDetailActivity::class.java)
        intent.putExtra("anime_id", anime.mal_id)
        startActivity(intent)
    }
}
