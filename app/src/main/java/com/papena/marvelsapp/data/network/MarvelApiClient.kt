package com.papena.marvelsapp.data.network

import com.papena.marvelsapp.data.models.character.CharacterDataWrapper
import com.papena.marvelsapp.data.models.comic.ComicDataContainer
import com.papena.marvelsapp.data.models.event.EventDataContainer
import com.papena.marvelsapp.data.models.serie.SerieDataContainer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface MarvelApiClient {

    @GET("v1/public/characters")
    fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("comics", encoded = true) comics : String?,
        @Query("series", encoded = true) series : String?,
        @Query("events", encoded = true) events : String?
    ): CompletableFuture<CharacterDataWrapper>

    @GET("v1/public/characters/{characterId}")
    fun getCharacterDetail(
        @Path("characterId") characterId: String
    ): CompletableFuture<CharacterDataWrapper>

    @GET("v1/public/comics")
    fun getComics(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): CompletableFuture<ComicDataContainer>

    @GET("v1/public/events")
    fun getEvents(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): CompletableFuture<EventDataContainer>

    @GET("v1/public/series")
    fun getSeries(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): CompletableFuture<SerieDataContainer>
}