package com.papena.marvelsapp.features.filter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.papena.marvelsapp.data.models.character.MarvelCharacter
import com.papena.marvelsapp.data.models.comic.ComicData
import com.papena.marvelsapp.data.models.event.EventData
import com.papena.marvelsapp.data.models.serie.SerieData
import com.papena.marvelsapp.usecases.GetComicsUseCase
import com.papena.marvelsapp.usecases.GetEventsUseCase
import com.papena.marvelsapp.usecases.GetSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase,
    private val getEventsUseCase: GetEventsUseCase,
    private val getSeriesUseCase: GetSeriesUseCase
): ViewModel() {

    val comics = MutableLiveData<List<ComicData>>()
    var offsetComics = 0
    fun getComics(offset: Int? = null){
        if (offset!=null){
            this.offsetComics
        }

        getComicsUseCase.saveFilters(
            this.offsetComics,
            20
        )
        if (this.offsetComics == 0){
            val response = getComicsUseCase()
            if (!response.isNullOrEmpty()){
                comics.value = response
                //this.offsetComics += 20
            }
        }
        else{
            val response = getComicsUseCase()
            if (!response.isNullOrEmpty()){
                comics.value = response
                //this.offsetComics += 20
            }
        }
    }
    val events = MutableLiveData<List<EventData>>()
    var offsetEvents = 0
    fun getEvents(offset: Int? = null){
        if (offset!=null){
            this.offsetEvents
        }

        getEventsUseCase.saveFilters(
            this.offsetEvents,
            20
        )
        if (this.offsetEvents == 0){
            val response = getEventsUseCase()
            if (!response.isNullOrEmpty()){
                events.value = response
                //this.offsetEvents += 20
            }
        }
        else{
            val response = getEventsUseCase()
            if (!response.isNullOrEmpty()){
                events.value = response
                //this.offsetEvents += 20
            }
        }
    }
    val series = MutableLiveData<List<SerieData>>()
    var offsetSeries = 0
    fun getSeries(offset: Int? = null){
        if (offset!=null){
            this.offsetSeries
        }

        getSeriesUseCase.saveFilters(
            this.offsetSeries,
            20
        )
        if (this.offsetSeries == 0){
            val response = getSeriesUseCase()
            if (!response.isNullOrEmpty()){
                series.value = response
                //this.offsetSeries += 20
            }
        }
        else{
            val response = getSeriesUseCase()
            if (!response.isNullOrEmpty()){
                series.value = response
                //this.offsetSeries += 20
            }
        }
    }




}