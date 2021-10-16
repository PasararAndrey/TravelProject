package com.travelproject.presentation.travel_details.details_main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.travelproject.R

class DetailsMainSliderAdapter(
    private val imageList: List<Int>,
) :
    SliderViewAdapter<DetailsMainSliderAdapter.TravelDetailsMainSliderViewHolder>() {

    class TravelDetailsMainSliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        val sliderImage: ImageView = itemView.findViewById<ImageView>(R.id.slider_image)
    }


    override fun onBindViewHolder(holder: TravelDetailsMainSliderViewHolder, position: Int) {
        val image = imageList[position]
        holder.sliderImage.setImageResource(image)
    }


    override fun getCount(): Int {
        return imageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): TravelDetailsMainSliderViewHolder {
        return TravelDetailsMainSliderViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.card_travel_details_main_images, parent, false)
        )

    }
}

