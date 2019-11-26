package de.chriskn.kotlinkata.domain

import java.math.BigDecimal

data class Book(
    val author: String,
    val title: String,
    val price: BigDecimal = BigDecimal.ZERO
)