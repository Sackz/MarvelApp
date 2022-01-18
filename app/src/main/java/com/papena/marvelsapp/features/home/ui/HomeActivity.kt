package com.papena.marvelsapp.features.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.papena.marvelsapp.components.MarvelToolbarType
import com.papena.marvelsapp.databinding.ActivityHomeBinding
import com.papena.marvelsapp.features.detail.ui.DetailActivity
import com.papena.marvelsapp.features.filter.ui.FilterActivity
import com.papena.marvelsapp.features.home.adapter.MarvelCharactersAdapter
import com.papena.marvelsapp.features.home.viewmodel.HomeViewModel
import com.papena.marvelsapp.utils.CHARACTER_ID
import com.papena.marvelsapp.utils.VerticalPaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

const val COMIC_IDS = "comic_ids"
const val SERIE_IDS = "serie_ids"
const val EVENT_IDS = "event_ids"

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var adapter: MarvelCharactersAdapter

    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var noMoreItems: Boolean = false

    var offset = 0

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            val comics = data?.extras?.getIntegerArrayList(COMIC_IDS)
            val series = data?.extras?.getIntegerArrayList(SERIE_IDS)
            val events = data?.extras?.getIntegerArrayList(EVENT_IDS)
            homeViewModel.saveFilters(comics,series,events)
            homeViewModel.getCharacters(0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()

        homeViewModel.getCharacters(0)
        homeViewModel.character.observe(this, Observer {
            noMoreItems = it.isEmpty()
            isLoading = false
            if (homeViewModel.offset == 0){
                adapter.replaceItems(it)
            }
            else{
                adapter.loadItems(it)
            }
            binding.list.isVisible = true
        })

        homeViewModel.noItems.observe(this, Observer {
            binding.list.isVisible = !it
        })

        homeViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.toolbar.toolbar.initToolbar(MarvelToolbarType.HOME){
            val intent = Intent(this, FilterActivity::class.java)
            resultLauncher.launch(intent)
        }
        binding.toolbar.toolbar.setToolbarTitle("Personajes")

    }

    fun setupAdapter(){
        binding.list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.list.addOnScrollListener(object : VerticalPaginationScrollListener(binding.list.layoutManager as LinearLayoutManager){
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                if (!noMoreItems){
                    isLoading = true
                    getMoreItems()
                }
            }
        })
        adapter = MarvelCharactersAdapter{
            val intent = Intent(this,DetailActivity::class.java)
            val bundle = Bundle().apply {
                this.putString(CHARACTER_ID, it.id.toString())
            }
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.list.adapter = adapter
    }

    fun getMoreItems(){
        homeViewModel.getCharacters()
    }

}