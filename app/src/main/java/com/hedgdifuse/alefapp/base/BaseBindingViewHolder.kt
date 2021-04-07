package com.hedgdifuse.alefapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hedgdifuse.alefapp.custom.viewBinding

/**
 * [BaseBindingViewHolder] - holder for [RecyclerView] with viewBinding
 */
open class BaseBindingViewHolder<VB: ViewBinding>(
    view: View,
    bindingInflater: (View) -> VB
): RecyclerView.ViewHolder(view) {

    val binding by viewBinding(bindingInflater)
}