package com.kishan.animeapp

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.kishan.animeapp.databinding.ActivityAnimeDetailBinding
import com.kishan.animeapp.repository.AnimeRepository
import com.kishan.animeapp.util.RetrofitClient

@Suppress("DEPRECATION")
class AnimeDetailActivity : AppCompatActivity() {
    private val viewModel: AnimeViewModel by viewModels {
        AnimeViewModelFactory(AnimeRepository(RetrofitClient.api))
    }
    private lateinit var exoPlayer: ExoPlayer
    private lateinit var binding: ActivityAnimeDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animeId = intent.getIntExtra("anime_id", 0)
        viewModel.fetchAnimeDetails(animeId)

        viewModel.selectedAnime.observe(this) { anime ->
            binding.titleTextView.text = anime.title
            binding.synopsisTextView.text = anime.synopsis
            binding.genreTextView.text = anime.genres.joinToString { it.name }
            binding.episodesTextView.text = "Episodes: ${anime.episodes}"
            binding.ratingTextView.text = "Rating: ${anime.score}"

            if (!anime.trailer?.url.isNullOrEmpty()) {
                playTrailer(anime.trailer!!.url!!)
            } else {
                Glide.with(this).load(anime.images.jpg.image_url).into(binding.posterImageView)
                binding.posterImageView.visibility = android.view.View.VISIBLE
                binding.playerView.visibility = android.view.View.GONE
            }
        }


    }

    private fun playTrailer(url: String) {
        exoPlayer = ExoPlayer.Builder(this).build()
        binding.playerView.player = exoPlayer
        val mediaItem = MediaItem.fromUri(Uri.parse(url))
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        print("Video Url: $url")
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer.release()
    }
}
