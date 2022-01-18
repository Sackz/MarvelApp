package com.papena.marvelsapp.features.filter.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.papena.marvelsapp.R
import com.papena.marvelsapp.features.filter.adapter.FilterAdapter
import com.papena.marvelsapp.features.filter.adapter.FilterItem
import com.papena.marvelsapp.features.home.ui.COMIC_IDS
import com.papena.marvelsapp.features.home.ui.EVENT_IDS
import com.papena.marvelsapp.features.home.ui.SERIE_IDS

class FilterHomeFragment: Fragment() {

    private lateinit var comic: ConstraintLayout
    private lateinit var event: ConstraintLayout
    private lateinit var serie: ConstraintLayout

    private lateinit var rvComic: RecyclerView
    private lateinit var rvSerie: RecyclerView
    private lateinit var rvEvent: RecyclerView

    private lateinit var imgComic: ImageView
    private lateinit var imgSerie: ImageView
    private lateinit var imgEvent: ImageView

    private lateinit var btnApply: Button
    private lateinit var btnClear: TextView

    private lateinit var adapterComic: FilterAdapter
    private lateinit var adapterSerie: FilterAdapter
    private lateinit var adapterEvent: FilterAdapter

    val viewModel by lazy {
        (requireActivity() as FilterActivity).filterViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_filter_serie,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi(view)

        viewModel.getComics(0)
        viewModel.comics.observe(this, Observer {
            val list = it.map { comic ->
                FilterItem(comic.title,comic.id.toString(),false)
            }
            adapterComic.loadItems(list)
        })
        viewModel.getEvents(0)
        viewModel.events.observe(this, Observer {
            val list = it.map { event ->
                FilterItem(event.title,event.id.toString(),false)
            }
            adapterEvent.loadItems(list)
        })
        viewModel.getSeries(0)
        viewModel.series.observe(this, Observer {
            val list = it.map { serie ->
                FilterItem(serie.title,serie.id.toString(),false)
            }
            adapterSerie.loadItems(list)
        })

    }

    private fun setupUi(view: View){
        comic = view.findViewById(R.id.container_comic)
        imgComic =  view.findViewById(R.id.img_comic)
        comic.setOnClickListener {
            if (rvComic.isVisible){
                rvComic.isVisible = false
                imgComic.setImageDrawable(resources.getDrawable(R.drawable.ic_chevron_right_black_24dp))

            }
            else{
                rvComic.isVisible = true
                imgComic.setImageDrawable(resources.getDrawable(R.drawable.ic_expand_more_black_24dp))
            }

        }
        event = view.findViewById(R.id.container_events)
        imgEvent = view.findViewById(R.id.img_event)
        event.setOnClickListener {
            if (rvEvent.isVisible){
                rvEvent.isVisible = false
                imgEvent.setImageDrawable(resources.getDrawable(R.drawable.ic_chevron_right_black_24dp))

            }
            else{
                rvEvent.isVisible = true
                imgEvent.setImageDrawable(resources.getDrawable(R.drawable.ic_expand_more_black_24dp))
            }
        }
        serie = view.findViewById(R.id.container_serie)
        imgSerie = view.findViewById(R.id.img_serie)
        serie.setOnClickListener {
            if (rvSerie.isVisible){
                rvSerie.isVisible = false
                imgSerie.setImageDrawable(resources.getDrawable(R.drawable.ic_chevron_right_black_24dp))

            }
            else{
                rvSerie.isVisible = true
                imgSerie.setImageDrawable(resources.getDrawable(R.drawable.ic_expand_more_black_24dp))
            }
        }

        rvComic = view.findViewById(R.id.rv_comics)
        rvComic.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        adapterComic = FilterAdapter {
            adapterComic.setSelected(it)
        }
        rvComic.adapter = adapterComic

        rvEvent = view.findViewById(R.id.rv_events)
        rvEvent.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        adapterEvent = FilterAdapter {
            adapterEvent.setSelected(it)
        }
        rvEvent.adapter = adapterEvent

        rvSerie = view.findViewById(R.id.rv_serie)
        rvSerie.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        adapterSerie = FilterAdapter {
            adapterSerie.setSelected(it)
        }
        rvSerie.adapter = adapterSerie

        btnApply = view.findViewById(R.id.btn_apply_filter)
        btnApply.setOnClickListener {
            requireActivity().setResult(RESULT_OK, Intent().apply {
                val bundle = Bundle()
                bundle.putIntegerArrayList(COMIC_IDS, adapterComic.getSelectedIds())
                bundle.putIntegerArrayList(SERIE_IDS, adapterSerie.getSelectedIds())
                bundle.putIntegerArrayList(EVENT_IDS, adapterEvent.getSelectedIds())
                this.putExtras(bundle)
            })
            requireActivity().finish()
        }
        btnClear = view.findViewById(R.id.btn_clear_filter)
        btnClear.setOnClickListener {
            //TODO
        }
    }
}
