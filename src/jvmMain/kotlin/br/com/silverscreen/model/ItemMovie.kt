package br.com.silverscreen.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import br.com.silverscreen.ui.ProgressCircular
import java.io.IOException
import java.math.BigDecimal
import java.net.URL

@Composable
fun ItemMovie(
    title: String?,
    image: String?,
    hit: BigDecimal?,
    year: Int?,

    ) {
    Column(modifier = Modifier.width(200.dp).padding(10.dp)) {


        AsyncImage(
            load = {
                loadImageBitmap(image)
            },
            painterFor = { remember { BitmapPainter(it) } },
            contentDescription = "Movie Preview",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.width(150.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(150.dp).padding(5.dp)
        ) {

            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star",
                    modifier = Modifier.size(18.dp),
                    tint = Color.Yellow
                )
                Text("$hit", fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            Text("$year", fontSize = 14.sp)

        }

        Spacer(Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(150.dp)
        ) {
            Text("$title", fontSize = 14.sp, textAlign = TextAlign.Center)
        }

    }
}

@Composable
fun <T> AsyncImage(
    load: suspend () -> T,
    painterFor: @Composable (T) -> Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    val image: T? by produceState<T?>(null) {
        value = withContext(Dispatchers.IO) {
            try {
                load()
            } catch (e: IOException) {

                e.printStackTrace()
                null
            }
        }
    }

    if (image != null) {
        Image(
            painter = painterFor(image!!),
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
    } else {
        Box(
            modifier = Modifier.height(188.dp),
            contentAlignment = Alignment.Center
        ) {
            ProgressCircular()
        }
    }
}

fun loadImageBitmap(url: String?): ImageBitmap =
    URL(url).openStream().buffered().use(::loadImageBitmap)