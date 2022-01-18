package com.papena.marvelsapp.features.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.papena.marvelsapp.data.models.character.MarvelCharacter
import com.papena.marvelsapp.usecases.GetCharactersUseCase
import com.papena.marvelsapp.usecases.GetComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val character = MutableLiveData<List<MarvelCharacter>>()
    val noItems = MutableLiveData<Boolean>()
    var offset = 0
    var comics: List<Int>? = null
    var series: List<Int>? = null
    var events: List<Int>? = null
    fun saveFilters(comics: List<Int>? = null, series: List<Int>? = null, events: List<Int>? = null){
        this.comics = comics
        this.series = series
        this.events = events
    }

    fun getCharacters(offset: Int? = null){
        if (offset!=null){
            this.offset = offset
        }

        getCharactersUseCase.saveFilters(
            this.offset,
            20,
            this.comics,
            this.series,
            this.events
        )
        if (this.offset == 0){
            isLoading.value = true
            val response = getCharactersUseCase()
            if (!response.isNullOrEmpty()){
                this.offset += 20
                noItems.value = false
            }
            else{
                noItems.value = true
            }
            character.value = response
            isLoading.value = false
        }
        else{
            val response = getCharactersUseCase()
            if (!response.isNullOrEmpty()){
                this.offset += 20
            }
            character.value = response
        }
    }

}