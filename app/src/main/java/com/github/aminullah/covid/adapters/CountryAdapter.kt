package com.github.aminullah.covid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.github.aminullah.covid.R
import com.github.aminullah.covid.listeneres.OnItemClickListener
import com.github.aminullah.covid.models.CountryNameModel

class CountryAdapter(var context: Context, var onItemClick: OnItemClickListener): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    var list = arrayListOf<CountryNameModel>()

    fun updateData(list: ArrayList<CountryNameModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_countries, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCountry.text = this.list[position].name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCountry = itemView.findViewById<AppCompatTextView>(R.id.tv_country)

        init {
            tvCountry.setOnClickListener {
                onItemClick.onItemClicked(adapterPosition)
            }
        }
    }
}