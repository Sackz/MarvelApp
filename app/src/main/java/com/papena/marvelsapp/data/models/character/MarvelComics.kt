package com.papena.marvelsapp.data.models.character

import java.io.Serializable

data class MarvelComics(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<MarvelComicSummary>?
): Serializable
