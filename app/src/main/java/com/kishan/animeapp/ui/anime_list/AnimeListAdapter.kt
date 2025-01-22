package com.kishan.animeapp.ui.anime_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kishan.animeapp.R
import com.kishan.animeapp.data.model.Anime
import com.kishan.animeapp.databinding.ItemAnimeBinding

class AnimeListAdapter(
    private var animeList: List<Anime>,
    private val onItemClick: (Anime) -> Unit
) : RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int = animeList.size

    fun updateList(newList: List<Anime>) {
        animeList = newList
        notifyDataSetChanged()
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(anime: Anime) {
            binding.animeTitle.text = anime.title
            binding.animeEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
            binding.animeRating.text = "Rating: ${anime.score ?: "N/A"}"

            Glide.with(binding.root.context)
                .load(anime.images.jpg.image_url)
                .placeholder(R.drawable.place_holder)
                .into(binding.animePoster)

            binding.root.setOnClickListener { onItemClick(anime) }
        }
    }
}
