package com.travelproject.presentation.travels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.travelproject.R
import com.travelproject.domain.model.TravelPreview

class TravelsAdapter(val travelsListener: TravelsListener) : ListAdapter<TravelPreview, TravelsAdapter.TravelViewHolder>(TravelDiffCallback) {

    class TravelViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val country = itemView.findViewById<TextView>(R.id.country)
        private val image = itemView.findViewById<ImageView>(R.id.image)
        fun bind(travelsListener: TravelsListener, travelPreview: TravelPreview) {
            country.text = travelPreview.country

            this.itemView.rootView.setOnClickListener {
                travelsListener.onClick(travelPreview)
            }
        }

        companion object {
            fun from(viewGroup: ViewGroup): TravelViewHolder {
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                val view = layoutInflater.inflate(R.layout.travels_list_item, viewGroup, false)
                return TravelViewHolder(view)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        return TravelViewHolder.from(viewGroup = parent)
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        holder.bind(travelsListener, getItem(position))
    }


    companion object {
        private object TravelDiffCallback : DiffUtil.ItemCallback<TravelPreview>() {
            override fun areItemsTheSame(oldItem: TravelPreview, newItem: TravelPreview): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TravelPreview, newItem: TravelPreview): Boolean {
                return oldItem == newItem
            }

        }
    }

}