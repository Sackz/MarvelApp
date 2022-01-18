package com.papena.marvelsapp.usecases

import com.papena.marvelsapp.data.repository.MarvelRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {

    private var offset: Int = 0
    private var limit: Int = 20
    private var comics: List<Int>? = null
    private var series: List<Int>? = null
    private var events: List<Int>? = null

    fun saveFilters(
        offset: Int = 0,
        limit: Int = 20,
        comics: List<Int>?,
        series: List<Int>?,
        events: List<Int>?
    ) {
        this.offset = offset
        this.limit = limit
        this.comics = comics
        this.series = series
        this.events = events
    }

    operator fun invoke() = repository.getCharacters(offset, limit, comics, series, events)
}