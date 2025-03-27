package com.example.rickandmortyapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.remote.ApiClient
import com.example.rickandmortyapp.data.repository.CharacterRepository
import com.example.rickandmortyapp.ui.adapter.CharacterPagerAdapter
import com.example.rickandmortyapp.viewmodel.CharacterViewModel
import com.example.rickandmortyapp.viewmodel.CharacterViewModelFactory

class MainActivity : AppCompatActivity() {
    private val repository = CharacterRepository(ApiClient.apiService)
    private val viewModel: CharacterViewModel by viewModels { CharacterViewModelFactory(repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        viewModel.characters.observe(this) { characters ->
            val adapter = CharacterPagerAdapter(supportFragmentManager, lifecycle, characters)
            viewPager.adapter = adapter
        }

        viewModel.fetchCharacters()
    }
}

