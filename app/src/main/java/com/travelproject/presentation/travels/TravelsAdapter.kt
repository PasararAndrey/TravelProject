package com.travelproject.presentation.travels

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.travelproject.R
import com.travelproject.domain.model.TravelPreview

class TravelsAdapter(
    private val context: Context,
    private val travelsList: List<TravelPreview>, private val listener: () -> Unit,

    ) : ListAdapter<TravelPreview, TravelsAdapter.TravelViewHolder>(TravelDiffUtil) {


    class TravelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageTravel)
        val title: TextView = itemView.findViewById(R.id.titleTravel)
    }

    object TravelDiffUtil : DiffUtil.ItemCallback<TravelPreview>() {
        override fun areItemsTheSame(oldItem: TravelPreview, newItem: TravelPreview): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: TravelPreview, newItem: TravelPreview): Boolean {
            return newItem == oldItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_travel, parent, false)
        return TravelViewHolder(view)
    }


    override fun getItemCount(): Int {
        return travelsList.size
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        val travel: TravelPreview = travelsList[position]
        holder.title.text = travel.title
        Glide.with(context).load(travel.image).into(holder.image)
        holder.itemView.setOnClickListener { listener() }
    }

}