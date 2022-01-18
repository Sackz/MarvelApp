package com.papena.marvelsapp.data.models.event

import com.papena.marvelsapp.data.models.comic.ComicDataContainer
import java.io.Serializable

data class EventDataContainer(
    val code: Int?,
    val status: String?,
    val copyright: String?,
    val data: EventDataWrapper?
): Serializable
