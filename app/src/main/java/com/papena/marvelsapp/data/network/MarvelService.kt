package com.papena.marvelsapp.data.network

import com.papena.marvelsapp.data.models.character.CharacterDataWrapper
import com.papena.marvelsapp.data.models.comic.ComicDataContainer
import com.papena.marvelsapp.data.models.event.EventDataContainer
import com.papena.marvelsapp.data.models.serie.SerieDataContainer
import javax.inject.Inject

class MarvelService @Inject constructor(
    private val apiClient: MarvelApiClient
){

    fun getCharacters(offset: Int, limit: Int, comics: List<Int>?, series: List<Int>?, events: List<Int>?): CharacterDataWrapper?{
        var comicsString: String? = null
        if (!comics?.joinToString(",").isNullOrEmpty()) comicsString = comics?.joinToString(",")
        var seriesString: String? = null
        if (!series?.joinToString(",").isNullOrEmpty()) seriesString = series?.joinToString(",")
        var eventsString: String? = null
        if (!events?.joinToString(",").isNullOrEmpty()) eventsString = events?.joinToString(",")
        return apiClient.getCharacters(offset,limit, comicsString, seriesString, eventsString).get()
    }

    fun getCharacterById(characterId: String): CharacterDataWrapper?{
        return apiClient.getCharacterDetail(characterId ).get()
    }

    fun getComics(offset: Int, limit: Int): ComicDataContainer?{
        return apiClient.getComics(offset,limit).get()
    }

    fun getEvents(offset: Int, limit: Int): EventDataContainer?{
        return apiClient.getEvents(offset,limit).get()
    }

    fun getSeries(offset: Int, limit: Int): SerieDataContainer?{
        return apiClient.getSeries(offset,limit).get()
    }
}