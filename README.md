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
   git clone https://github.com/yourusername/animeapp.git
