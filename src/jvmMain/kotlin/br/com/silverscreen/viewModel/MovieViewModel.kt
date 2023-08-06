package br.com.silverscreen.viewModel

import java.math.BigDecimal

data class MovieViewModel (
    val title: String,
    val image: String,
    val hit: BigDecimal,
    val year: Int
)
