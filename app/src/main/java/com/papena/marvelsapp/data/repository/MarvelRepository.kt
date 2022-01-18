package com.papena.marvelsapp.data.repository

import com.papena.marvelsapp.data.models.character.MarvelCharacter
import com.papena.marvelsapp.data.models.comic.ComicData
import com.papena.marvelsapp.data.models.event.EventData
import com.papena.marvelsapp.data.models.serie.SerieData
import com.papena.marvelsapp.data.network.MarvelService
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val api: MarvelService
) {

    fun getCharacters(offset: Int, limit: Int, comics: List<Int>?, series: List<Int>?, events: List<Int>?): List<MarvelCharacter> {
        return api.getCharacters(offset,limit,comics, series, events)?.data?.results ?: emptyList()
    }

    fun getCharacterInfo(characterId: String): MarvelCharacter? {
        return api.getCharacterById(characterId)?.data?.results?.first()
    }

    fun getComics(offset: Int, limit: Int): List<ComicData> {
        return api.getComics(offset,limit)?.data?.results ?: emptyList()
    }

    fun getEvents(offset: Int, limit: Int): List<EventData> {
        return api.getEvents(offset,limit)?.data?.results ?: emptyList()
    }

    fun getSeries(offset: Int, limit: Int): List<SerieData> {
        return api.getSeries(offset,limit)?.data?.results ?: emptyList()
    }
}