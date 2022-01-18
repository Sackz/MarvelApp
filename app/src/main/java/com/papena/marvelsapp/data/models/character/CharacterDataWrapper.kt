package com.papena.marvelsapp.data.models.character

import java.io.Serializable

data class CharacterDataWrapper(
    val code: Int?,
    val status: String?,
    val copyright: String?,
    val data: CharacterDataContainer?
): Serializable
