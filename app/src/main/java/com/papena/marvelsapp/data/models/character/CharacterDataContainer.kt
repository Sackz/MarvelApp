package com.papena.marvelsapp.data.models.character

import java.io.Serializable

data class CharacterDataContainer(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: List<MarvelCharacter>
): Serializable
