package com.papena.marvelsapp.data.models.comic

import com.papena.marvelsapp.data.models.character.MarvelCharacter
import java.io.Serializable

data class ComicDataWrapper(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: List<ComicData>
): Serializable
