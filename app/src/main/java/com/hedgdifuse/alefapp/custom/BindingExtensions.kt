package com.hedgdifuse.alefapp.custom

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * [viewBinding] - delegate for implement viewBinding.
 */
inline fun <T> Activity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy { bindingInflater.invoke(LayoutInflater.from(this)) }

inline fun <T> RecyclerView.ViewHolder.viewBinding(
    crossinline bindingInflater: (View) -> T
) = lazy { bindingInflater.invoke(itemView) }
