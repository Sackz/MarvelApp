package com.papena.marvelsapp.data.models.character

import java.io.Serializable

data class MarvelSeries(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<MarvelSerieSummary>?
): Serializable
