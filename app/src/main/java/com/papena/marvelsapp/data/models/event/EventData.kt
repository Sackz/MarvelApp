package com.papena.marvelsapp.data.models.event

import com.papena.marvelsapp.data.models.character.MarvelImage
import java.io.Serializable

data class EventData(
    var id: Int,
    var title: String,
    var description: String,
    val thumbnail: MarvelImage?,
): Serializable
