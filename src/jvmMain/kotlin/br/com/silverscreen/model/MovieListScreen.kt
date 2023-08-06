package br.com.silverscreen.model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import java.math.BigDecimal

@Composable
fun MovieListScreen(movieViewModelLists: List<MovieItem>?) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center
    ) {
        if (movieViewModelLists != null) {

            items(movieViewModelLists) { movie ->
                ItemMovie(
                    title = movie.title,
                    image = movie.image,
                    hit = BigDecimal(movie.imDbRating),
                    year = movie.year?.toInt()
                )
            }
        } else {
            println("Failed request::")
        }
    }
}

