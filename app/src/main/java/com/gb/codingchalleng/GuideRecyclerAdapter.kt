package com.gb.codingchalleng

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GuideRecyclerAdapter(val guideList: Guides): RecyclerView.Adapter<GuideRecyclerAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.nameTextView)
        var dates : TextView = itemView.findViewById(R.id.dateTextView)
        var venue: TextView = itemView.findViewById(R.id.venueTextView)
        var icon: ImageView = itemView.findViewById(R.id.iconImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_guide, parent, false))
    }

    override fun getItemCount(): Int {
        return guideList.guidesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val guide = guideList.guidesList[position]
        holder.name.text = guide.name
        holder.dates.text = if (guide.startDate != null && guide.endDate != null) {
            "${guide.startDate} - ${guide.endDate}"
        } else {
            "Dates Unavailable"
        }
        holder.venue.text = if (guide.venue?.city != null && guide.venue?.state != null) {
            "${guide.venue!!.city}, ${guide.venue!!.state}"
        } else {
            "Venue information unavailable"
        }
        if (guide.icon != null) {

            Glide
                .with(holder.itemView.context)
                .load(guide.icon)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.icon);
        }
    }
}