package com.papena.marvelsapp.data.models.comic

import com.papena.marvelsapp.data.models.character.MarvelImage
import java.io.Serializable
import java.util.*

data class ComicData(
    var id: Int,
    var title: String,
    var description: String,
    val thumbnail: MarvelImage?,
): Serializable
