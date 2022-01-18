package com.papena.marvelsapp.data.models.serie

import com.papena.marvelsapp.data.models.comic.ComicDataContainer
import java.io.Serializable

data class SerieDataContainer(
    val code: Int?,
    val status: String?,
    val copyright: String?,
    val data: SerieDataWrapper?
): Serializable
