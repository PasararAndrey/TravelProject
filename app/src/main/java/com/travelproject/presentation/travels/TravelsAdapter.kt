package com.travelproject.presentation.travels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.travelproject.databinding.TravelsListItemBinding
import com.travelproject.domain.model.TravelPreview

class TravelsAdapter(private val travelsListener: TravelsListener) : ListAdapter<TravelPreview, TravelsAdapter.TravelViewHolder>(TravelDiffCallback) {

    inner class TravelViewHolder constructor(private val binding: TravelsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val travel = getItem(position)
                    travelsListener.onClick(travel)
                }
            }
        }

        fun bind(travelPreview: TravelPreview) {
            binding.apply {
                country.text = travelPreview.country
                Glide.with(this@TravelViewHolder.itemView.context)
                    .load(travelPreview.image)
                    .centerInside()
                    .into(mainImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = TravelsListItemBinding.inflate(layoutInflater, parent, false)
        return TravelViewHolder(view)
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        val currentTravelPreview = getItem(position)
        holder.bind(currentTravelPreview)
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