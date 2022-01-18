package com.papena.marvelsapp.data.models.character

import java.io.Serializable
import java.util.*

data class MarvelCharacter(
    val id : Int?,
    val name: String?,
    val description: String?,
    val modified : Date?,
    val resourceURI: String?,
    val urls: List<MarvelUrl>?,
    val thumbnail: MarvelImage?,
    val comics: MarvelComics?,
    val stories: MarvelStories,
    val events: MarvelEvents,
    val series: MarvelSeries
): Serializable