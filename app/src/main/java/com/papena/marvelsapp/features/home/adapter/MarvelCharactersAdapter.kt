package com.papena.marvelsapp.features.home.adapter

import android.net.Uri

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.view.ViewGroup

import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.papena.marvelsapp.data.models.character.MarvelCharacter


class MarvelCharactersAdapter(private val onItemClick: ((character: MarvelCharacter) -> Unit)) :
    RecyclerView.Adapter<MarvelCharacterHolder>() {
    private var list: MutableList<MarvelCharacter> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCharacterHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MarvelCharacterHolder(inflater, parent, onItemClick)
    }

    override fun onBindViewHolder(holder: MarvelCharacterHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun loadItems(characters: List<MarvelCharacter>){
        list.addAll(characters)
        notifyDataSetChanged()
    }

    fun replaceItems(characters: List<MarvelCharacter>){
        list = characters.toMutableList()
        notifyDataSetChanged()
    }

}

// stores and recycles views as they are scrolled off screen
class MarvelCharacterHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val onItemClick: (character: MarvelCharacter) -> Unit
) : RecyclerView.ViewHolder(inflater.inflate(com.papena.marvelsapp.R.layout.item_marvel_character_cell, parent, false)) {

    private lateinit var imgCharacter : ImageView
    private lateinit var txtCharacterName: TextView

    fun bind(character: MarvelCharacter){
        setupUi()
        loadMarvelCharacterData(character)
    }

    private fun setupUi() {
        imgCharacter = itemView.findViewById(com.papena.marvelsapp.R.id.img_character)
        txtCharacterName = itemView.findViewById(com.papena.marvelsapp.R.id.txt_name_character)

    }

    private fun loadMarvelCharacterData(character: MarvelCharacter){
        txtCharacterName.text = character.name

        if (character.thumbnail!!.extension == "gif"){
            Glide
                .with(itemView)
                .asGif()
                .load(Uri.parse(character.thumbnail.path+"."+character.thumbnail.extension))
                .centerCrop()
                .into(imgCharacter)
        }
        else{
            Glide
                .with(itemView)
                .load(Uri.parse(character.thumbnail.path+"."+character.thumbnail.extension))
                .centerCrop()
                .into(imgCharacter)
        }


        itemView.setOnClickListener {
            onItemClick(character)
        }
    }

}