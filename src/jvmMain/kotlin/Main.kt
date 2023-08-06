
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.silverscreen.model.MovieItem
import br.com.silverscreen.model.MovieListScreen
import br.com.silverscreen.networking.MovieWebClient
import br.com.silverscreen.ui.ProgressCircular
import br.com.silverscreen.ui.ShowSplashScreen
import java.util.*
import kotlin.concurrent.schedule


@Composable
@Preview
fun App(
    movieViewModelLists: List<MovieItem>?,
) {

        MovieListScreen(movieViewModelLists)

}


fun main() = application {

    var allMovies by remember { mutableStateOf(emptyList<MovieItem>()) }
    var loading by remember { mutableStateOf(true) }
    var showSplash by remember { mutableStateOf(true) }

    MovieWebClient().findTop250Movies { movies ->
        if (movies != null) {

            allMovies = movies.items!!

            loading = false

        } else {

            println("Movies failed::")
        }
    }


    if (showSplash) {

        ShowSplashScreen()

        Timer().schedule(3000) {
            showSplash = false
        }
    }

    if(!showSplash) {
        Window(
            title = "Silver-Screen Platform",
            icon = painterResource("Silver Screen.png"),
            onCloseRequest = ::exitApplication
        ) {
            MaterialTheme(colors = darkColors()) {

                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                    if (loading) {
                        ProgressCircular()
                    } else {
                        App(allMovies)

                    }
                }
            }
        }
    }

}



