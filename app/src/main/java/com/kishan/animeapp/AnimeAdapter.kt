package com.kishan.animeapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.databinding.ItemAnimeBinding

class AnimeAdapter(private val onClick: (Anime) -> Unit) :
    ListAdapter<Anime, AnimeAdapter.AnimeViewHolder>(AnimeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(anime: Anime) {
            binding.titleTextView.text = anime.title
            binding.episodesTextView.text = "Episodes: ${anime.episodes}"
            binding.ratingTextView.text = "Rating: ${anime.score}"
            Glide.with(binding.root.context).load(anime.images.jpg.image_url).into(binding.posterImageView)

            binding.root.setOnClickListener { onClick(anime) }
        }
    }
}

class AnimeDiffCallback : DiffUtil.ItemCallback<Anime>() {
    override fun areItemsTheSame(oldItem: Anime, newItem: Anime) = oldItem.mal_id == newItem.mal_id
    override fun areContentsTheSame(oldItem: Anime, newItem: Anime) = oldItem == newItem
}

