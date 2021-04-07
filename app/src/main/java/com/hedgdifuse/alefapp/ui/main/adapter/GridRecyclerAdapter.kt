package com.hedgdifuse.alefapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hedgdifuse.alefapp.R
import com.hedgdifuse.alefapp.base.BaseBindingViewHolder
import com.hedgdifuse.alefapp.databinding.ItemGridImageBinding

class GridRecyclerAdapter: RecyclerView.Adapter<GridRecyclerAdapter.GridRecyclerViewHolder>() {

    var items = emptyList<String>()
    var onItemClick: (String) -> Unit = {}

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GridRecyclerViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_grid_image, parent, false)
        )
    override fun onBindViewHolder(holder: GridRecyclerViewHolder, position: Int) {
        holder.load(items[position])
    }

    inner class GridRecyclerViewHolder(v: View): BaseBindingViewHolder<ItemGridImageBinding>(
        v,
        ItemGridImageBinding::bind
    ) {
        // Load image
        fun load(image: String) {
            binding.gridImage.setImageURI(image)

            // Add click event
            binding.root.setOnClickListener { onItemClick(image) }

            // Add similar height of width
            binding.root.post {
                with(binding.root.layoutParams) {
                    height = binding.root.measuredWidth
                }

                // Update view with new height
                binding.root.requestLayout()
            }
        }
    }
}