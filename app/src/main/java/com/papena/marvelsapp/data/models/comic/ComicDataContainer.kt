package com.papena.marvelsapp.data.models.comic

import com.papena.marvelsapp.data.models.character.CharacterDataContainer
import java.io.Serializable

data class ComicDataContainer(
    val code: Int?,
    val status: String?,
    val copyright: String?,
    val data: ComicDataWrapper
): Serializable

