package com.example.rickandmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character

class CharacterAdapter(private var characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.character_name)
        val imageView: ImageView = view.findViewById(R.id.character_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.nameTextView.text = character.name
        Glide.with(holder.itemView.context).load(character.image).into(holder.imageView)
    }
    fun updateList(newCharacters: List<Character>) {
        val diffCallback = object : DiffUtil.Callback() {
            override fun getOldListSize() = characters.size
            override fun getNewListSize() = newCharacters.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                characters[oldItemPosition].id == newCharacters[newItemPosition].id
            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                characters[oldItemPosition] == newCharacters[newItemPosition]
        }
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        characters = newCharacters
        diffResult.dispatchUpdatesTo(this)
    }
    override fun getItemCount(): Int = characters.size
}

