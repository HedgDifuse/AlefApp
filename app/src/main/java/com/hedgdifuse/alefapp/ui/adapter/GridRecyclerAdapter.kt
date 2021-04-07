package com.hedgdifuse.alefapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hedgdifuse.alefapp.R
import com.hedgdifuse.alefapp.base.BaseBindingViewHolder
import com.hedgdifuse.alefapp.databinding.ItemGridImageBinding

class GridRecyclerAdapter: RecyclerView.Adapter<GridRecyclerAdapter.GridRecyclerViewHolder>() {

    var items = emptyList<String>()

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
        fun load(image: String) = binding.gridImage.setImageURI(image)
    }
}