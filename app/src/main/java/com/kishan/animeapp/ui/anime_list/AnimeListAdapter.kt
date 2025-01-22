package com.kishan.animeapp.ui.anime_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kishan.animeapp.R
import com.kishan.animeapp.data.model.Anime


class AnimeListAdapter(private val animeList: List<Anime>, private val onItemClick: (Anime) -> Unit) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int = animeList.size

    inner class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(anime: Anime) {
//            itemView.animeTitle.text = anime.title
//            itemView.animeEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
//            itemView.animeRating.text = "Rating: ${anime.score ?: "N/A"}"
//
//            Glide.with(itemView.context)
//                .load(anime.images.jpg.image_url)
//                .placeholder(R.drawable.placeholder_image)
//                .into(itemView.animePoster)

            itemView.setOnClickListener { onItemClick(anime) }
        }
    }
}
