package com.papena.marvelsapp.features.detail.ui

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.papena.marvelsapp.components.MarvelToolbarType
import com.papena.marvelsapp.data.models.character.MarvelCharacter
import com.papena.marvelsapp.databinding.ActivityDetailBinding
import com.papena.marvelsapp.features.detail.viewmodel.DetailViewModel
import com.papena.marvelsapp.utils.CHARACTER_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            detailViewModel.characterId  = it.getString(CHARACTER_ID, "")
        }

        if (detailViewModel.characterId.isNotBlank()){
            detailViewModel.getCharacterInfo()
        }

        detailViewModel.characterInfo.observe(this, Observer {
            loadInfo(it)
            binding.toolbar.let { tBar ->
                tBar.toolbar.initToolbar(MarvelToolbarType.DETAIL) { onBackPressed() }
            }
        })

               }

    private fun loadInfo(character: MarvelCharacter){
        binding.toolbar.toolbar.setToolbarTitle(character.name!!)

        if (character.description.isNullOrEmpty()){
            binding.tvDescription.text = "Sin descripcion"
        }
        else{
            binding.tvDescription.text = character.description
        }
        if (character.comics?.items?.isNotEmpty() == true){
            binding.tvComics.text = "Apariciones en comics: ${character.comics.items.size}"
        }
        if (character.events.items?.isNotEmpty() == true){
            binding.tvEvents.text = "Participaciones en eventos: ${character.events.items.size}"
        }
        if (character.series.items?.isNotEmpty() == true){
            binding.tvSeries.text = "Participaciones en series: ${character.series.items.size}"
        }

        if (character.thumbnail!!.extension == "gif"){
            Glide
                .with(this)
                .asGif()
                .load(Uri.parse(character.thumbnail.path+"."+character.thumbnail.extension))
                .centerCrop()
                .into(binding.imaCharacter)
        }
        else{
            Glide
                .with(this)
                .load(Uri.parse(character.thumbnail.path+"."+character.thumbnail.extension))
                .centerCrop()
                .into(binding.imaCharacter)
        }

    }

}