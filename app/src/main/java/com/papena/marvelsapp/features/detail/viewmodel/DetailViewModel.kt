package com.papena.marvelsapp.features.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.papena.marvelsapp.data.models.character.MarvelCharacter
import com.papena.marvelsapp.usecases.GetCharacterInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterInfoUseCase: GetCharacterInfoUseCase
): ViewModel() {

    var characterId: String = ""
    var characterInfo = MutableLiveData<MarvelCharacter>()
    fun getCharacterInfo(){
        getCharacterInfoUseCase.saveCharacterId(characterId)

        val response = getCharacterInfoUseCase()
        if (response!=null){
            characterInfo.value = response!!
        }
    }
}