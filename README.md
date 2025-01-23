# Anime App - Kotlin Android Project

This is a simple Android app built using **Kotlin**, **Retrofit**, **MVVM architecture**, **ExoPlayer**, and **Glide**. The app allows users to view a list of popular anime series and watch trailers for the selected anime. It fetches data from the Jikan API (MyAnimeList API) and displays the details, including the trailer if available.

## Features

- Fetches a list of popular/top-rated anime using the Jikan API.
- Displays a list of anime with the following details:
  - Title
  - Number of Episodes
  - Rating
  - Poster Image
- On selecting an anime, it opens a **Details Page** with:
  - Title
  - Plot/Synopsis
  - Genre(s)
  - Main Cast
  - Number of Episodes
  - Rating
  - Trailer video (if available)
  
## Libraries Used

- **Retrofit**: For making network requests and fetching data from the API.
- **MVVM**: To separate the data layer, business logic, and presentation layer.
- **ExoPlayer**: To play video trailers in the details page.
- **Glide**: To load images (e.g., anime posters) into the views.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/KishanSingh1993/animeApp.git

Setup Jikan API
This app uses the Jikan API to fetch anime data. The Jikan API endpoint used for fetching the top-rated anime is:

Top Anime API: https://api.jikan.moe/v4/top/anime
Anime Detail API: https://api.jikan.moe/v4/anime/{anime_id}
No additional API key is needed as the Jikan API is a free public API.

Project Structure
MainActivity.kt: The home page of the app where the list of top anime is displayed.
AnimeDetailActivity.kt: The details page where the selected anime's details and trailer (if available) are shown.
AnimeViewModel.kt: The ViewModel for fetching and holding the anime list.
AnimeDetailViewModel.kt: The ViewModel for fetching and holding the selected anime's details.
AnimeRepository.kt: The repository for managing data fetching from the Jikan API.
AnimeAdapter.kt: The adapter for displaying anime items in the RecyclerView.
activity_anime_list.xml: Layout for displaying the anime list.
activity_anime_detail.xml: Layout for displaying the selected anime's details and the ExoPlayer for the trailer.
How It Works
1. Fetching Top Anime (Anime List Page)
   In MainActivity.kt, the AnimeViewModel fetches a list of top-rated anime from the Jikan API and stores it in the animeList LiveData. The AnimeAdapter is used to display the list of anime titles, episode count, ratings, and poster images in a RecyclerView.


viewModel.fetchTopAnime()  // Fetch the top anime list
When an anime item is clicked, the app navigates to the AnimeDetailActivity passing the selected anime's ID.

2. Fetching Anime Details (Anime Detail Page)
   In AnimeDetailActivity.kt, the AnimeDetailViewModel fetches the detailed information about a specific anime using its ID. The data includes the title, synopsis, genres, number of episodes, and rating. If the anime has a trailer, the trailer URL is extracted from the trailer object, and the video is played using ExoPlayer.

viewModel.fetchAnimeDetails(animeId)  // Fetch the details for the selected anime
If no trailer is available, the poster image is displayed using Glide.

3. ExoPlayer for Video Trailer
   If the anime has a trailer URL, ExoPlayer is used to load and play the trailer in the detail page:

fun playTrailer(url: String) {
exoPlayer = ExoPlayer.Builder(this).build()
playerView.player = exoPlayer
val mediaItem = MediaItem.fromUri(Uri.parse(url))
exoPlayer.setMediaItem(mediaItem)
exoPlayer.prepare()
exoPlayer.playWhenReady = true
}
4. Error Handling
   Error messages (such as network errors or invalid data) are displayed using a LiveData object, which is observed and shown to the user.

viewModel.errorMessage.observe(this) { error ->
// Show error message to the user
}
Folder Structure

├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── kishan
│   │   │   │           └── animeapp
│   │   │   │               ├── AnimeDetailActivity.kt
│   │   │   │               ├── AnimeAdapter.kt
│   │   │   │               ├── AnimeRepository.kt
│   │   │   │               ├── AnimeViewModel.kt
│   │   │   │               ├── AnimeDetailViewModel.kt
│   │   │   │               ├── AnimeViewModelFactory.kt
│   │   │   │               └── data
│   │   │   │                   └── model
│   │   │   │                       ├── Anime.kt
│   │   │   │                       ├── Genre.kt
│   │   │   │                       ├── Images.kt
│   │   │   │                       ├── Trailer.kt
│   │   │   │                       └── AnimeResponse.kt
│   │   │   ├── res
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_anime_list.xml
│   │   │   │   │   └── activity_anime_detail.xml
│   │   │   │   └── drawable
│   │   │   │       └── exo_player_icon.xml

# Screenshot

<img src="/ss/1.png" height="400px"/> || <img src="/ss/2.png" height="400px"/>