package com.travelproject.presentation.travels

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.travelproject.R
import com.travelproject.domain.model.TravelPreview

class TravelsAdapter : RecyclerView.Adapter<TravelsAdapter.TravelViewHolder>() {
    var travels = listOf<TravelPreview>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class TravelViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val daysAmount = itemView.findViewById<TextView>(R.id.days_amount)
        private val country = itemView.findViewById<TextView>(R.id.country)
        fun bind(travelPreview: TravelPreview) {
            daysAmount.text = travelPreview.daysAmount.toString()
            country.text = travelPreview.country
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
        holder.bind(travels[position])
    }

    override fun getItemCount(): Int {
        return travels.count()
    }

}