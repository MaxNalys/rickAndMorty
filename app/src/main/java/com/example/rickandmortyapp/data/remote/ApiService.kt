package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>
}
