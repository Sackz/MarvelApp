package com.papena.marvelsapp.data.models.serie

import com.papena.marvelsapp.data.models.character.MarvelCharacter
import java.io.Serializable

data class SerieDataWrapper(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: List<SerieData>
): Serializable
