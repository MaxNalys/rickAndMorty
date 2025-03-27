package com.example.rickandmortyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character

class CharacterFragment : Fragment() {

    private var character: Character? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        character = arguments?.getParcelable(ARG_CHARACTER)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = view.findViewById(R.id.character_image)
        val nameTextView: TextView = view.findViewById(R.id.character_name)
        val statusTextView: TextView = view.findViewById(R.id.character_status)
        val speciesTextView: TextView = view.findViewById(R.id.character_species)

        character?.let {
            nameTextView.text = it.name
            statusTextView.text = it.status
            speciesTextView.text = it.species

            Glide.with(this)
                .load(it.image)
                .into(imageView)
        } ?: run {
            nameTextView.text = "Unknown"
            statusTextView.text = "Unknown"
            speciesTextView.text = "Unknown"
        }
    }

    companion object {
        private const val ARG_CHARACTER = "character"

        fun newInstance(character: Character) =
            CharacterFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CHARACTER, character)
                }
            }
    }
}
