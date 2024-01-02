package com.dimthomas.gpstracker.db

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dimthomas.gpstracker.R
import com.dimthomas.gpstracker.databinding.TrackItemBinding

class TrackAdapter(private val listener: Listener): ListAdapter<TrackItem, TrackAdapter.Holder>(Comparator()) {

    class Holder(view: View, private val listener: Listener): RecyclerView.ViewHolder(view), OnClickListener  {

        private val binding = TrackItemBinding.bind(view)
        private var trackTemp: TrackItem? = null

        init {
            binding.deleteIbtn.setOnClickListener(this)
        }

        fun bind(trackItem: TrackItem) = with(binding) {
            trackTemp  =trackItem
            val speed = "${trackItem.velocity} km/h"
            val distance = "${trackItem.distance} km"
            dateTv.text = trackItem.date
            speedTv.text = speed
            timeTv.text = trackItem.time
            distanceTv.text = distance
        }

        override fun onClick(p0: View?) {
            trackTemp?.let { listener.onClick(it) }
        }
    }

    class Comparator: DiffUtil.ItemCallback<TrackItem>() {
        override fun areItemsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.track_item, parent, false)
        return Holder(view, listener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onClick(trackItem: TrackItem)
    }
}