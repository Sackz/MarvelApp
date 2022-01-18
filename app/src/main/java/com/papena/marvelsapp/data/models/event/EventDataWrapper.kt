package com.papena.marvelsapp.data.models.event

import com.papena.marvelsapp.data.models.character.MarvelCharacter
import java.io.Serializable

data class EventDataWrapper(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: List<EventData>
): Serializable