package com.papena.marvelsapp.features.filter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.papena.marvelsapp.R

class FilterAdapter(private val onItemClick: ((position: Int) -> Unit)) :
    RecyclerView.Adapter<FilterHolder>() {
    private var list: MutableList<FilterItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilterHolder(inflater, parent, onItemClick)
    }

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        holder.bind(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun loadItems(characters: List<FilterItem>){
        list.addAll(characters)
        notifyDataSetChanged()
    }

    fun setSelected(position: Int){
        list[position].selected=!list[position].selected
    }

    fun getSelectedIds(): ArrayList<Int>{
        return list.filter {
            it.selected
        }.map {
            it.id.toInt()
        } as ArrayList<Int>
    }

}

// stores and recycles views as they are scrolled off screen
class FilterHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_filter_cell, parent, false)) {

    private lateinit var txtName: TextView
    private lateinit var imgCheck : ImageView

    fun bind(item: FilterItem,position: Int){
        setupUi()
        loadFilterData(item,position)
    }

    private fun setupUi() {
        imgCheck = itemView.findViewById(R.id.filter_check)
        txtName = itemView.findViewById(R.id.filter_name)

    }

    private fun loadFilterData(item: FilterItem, position: Int){
        txtName.text = item.name


        itemView.setOnClickListener {
            if (item.selected){
                imgCheck.setImageDrawable(itemView.context.getDrawable(R.drawable.ic_radio_button_unchecked_black_24dp))
            }
            else{
                imgCheck.setImageDrawable(itemView.context.getDrawable(R.drawable.ic_check_circle_black_24dp))
            }
            onItemClick(position)
        }
    }

}