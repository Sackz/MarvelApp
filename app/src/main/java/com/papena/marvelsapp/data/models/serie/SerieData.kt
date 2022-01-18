package com.papena.marvelsapp.data.models.serie

import com.papena.marvelsapp.data.models.character.MarvelImage
import java.io.Serializable

data class SerieData(
    var id: Int,
    var title: String,
    var description: String,
    val thumbnail: MarvelImage?,
): Serializable
