package com.papena.marvelsapp.usecases

import com.papena.marvelsapp.data.models.character.MarvelCharacter
import com.papena.marvelsapp.data.repository.MarvelRepository
import javax.inject.Inject

class GetCharacterInfoUseCase @Inject constructor(
    private val repository: MarvelRepository
) {

    private var characterId : String? = null
    fun saveCharacterId(id: String){
        characterId = id
    }

    operator fun invoke(): MarvelCharacter? {
        characterId?.let{
            return repository.getCharacterInfo(it)
        }
        return null
    }
}