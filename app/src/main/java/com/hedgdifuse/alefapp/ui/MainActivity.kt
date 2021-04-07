package com.hedgdifuse.alefapp.ui

import android.os.Bundle
import android.os.strictmode.Violation
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.hedgdifuse.alefapp.Constants.PHONE_SPAN_COUNT
import com.hedgdifuse.alefapp.Constants.TABLET_SPAN_COUNT
import com.hedgdifuse.alefapp.R
import com.hedgdifuse.alefapp.base.BaseBindingActivity
import com.hedgdifuse.alefapp.databinding.ActivityMainBinding
import com.hedgdifuse.alefapp.ui.adapter.GridRecyclerAdapter
import com.hedgdifuse.alefapp.viewmodel.ImagesViewModel
import com.hedgdifuse.alefapp.viewmodel.state.ViewModelState

class MainActivity : BaseBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val adapter = GridRecyclerAdapter()
    private val viewModel: ImagesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Variable for spanCount
        val spanCount =
            if(resources.getBoolean(R.bool.isTablet)) TABLET_SPAN_COUNT
            else PHONE_SPAN_COUNT

        // Add observer from viewModel
        viewModel.images.observe(this) {
            binding.mainErrorLayout.isVisible = it is ViewModelState.Errored
            binding.mainProgress.isVisible = it is ViewModelState.Loading && adapter.items.isEmpty()

            binding.mainContentLayout.isVisible =
                (it is ViewModelState.Success || adapter.items.isNotEmpty()) && it !is ViewModelState.Errored

            if(it is ViewModelState.Success) {
                if(!adapter.items.containsAll(it.data)) {
                    adapter.items = it.data
                    adapter.notifyDataSetChanged()
                }

                binding.mainContentLayout.isRefreshing = false
            } else if(it is ViewModelState.Errored) {
                binding.mainContentLayout.isRefreshing = false
            }
        }

        // Settings SwipeRefreshLayout
        with(binding.mainContentLayout) {
            setColorSchemeResources(android.R.color.white)
            setProgressBackgroundColorSchemeResource(R.color.colorPrimaryDark)

            setOnRefreshListener {
                viewModel.fetchImages()
            }
        }

        // On retry
        binding.mainErrorRefresh.setOnClickListener {
            viewModel.fetchImages()
        }

        // Setting RecyclerView
        with(binding.mainRecycler) {
            adapter = this@MainActivity.adapter
            layoutManager = GridLayoutManager(context, spanCount)
        }
    }
}