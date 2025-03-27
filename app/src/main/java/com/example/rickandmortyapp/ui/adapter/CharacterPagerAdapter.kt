package com.example.rickandmortyapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.ui.CharacterFragment

class CharacterPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val characters: List<Character>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = characters.size

    override fun createFragment(position: Int): Fragment {
        return CharacterFragment.newInstance(characters[position])
    }
}
