package com.papena.marvelsapp.usecases

import com.papena.marvelsapp.data.repository.MarvelRepository
import javax.inject.Inject

class GetSeriesUseCase @Inject constructor(
    private val repository: MarvelRepository
) {

    private var offset: Int = 0
    private var limit: Int = 20

    fun saveFilters(
        offset: Int = 0,
        limit: Int = 20
    ) {
        this.offset = offset
        this.limit = limit
    }

    operator fun invoke() = repository.getSeries(offset, limit)
}