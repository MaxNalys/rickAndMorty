package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.remote.ApiService

class CharacterRepository(
    private val apiService: ApiService
) {
    suspend fun getCharacters(): List<Character> {
        val response = apiService.getCharacters()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("Failed to fetch characters: ${response.code()}")
        }
    }
}
