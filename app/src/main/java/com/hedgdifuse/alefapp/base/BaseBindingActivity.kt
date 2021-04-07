package com.hedgdifuse.alefapp.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.hedgdifuse.alefapp.R
import com.hedgdifuse.alefapp.custom.viewBinding

/**
 * [BaseBindingActivity] - base activity, implement binding feature.
 */
open class BaseBindingActivity<VB: ViewBinding>(
    bindingInflater: (LayoutInflater) -> VB
): AppCompatActivity() {

    val binding by viewBinding(bindingInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set custom theme for implement splash screen feature
        setTheme(R.style.Theme_AlefApp)
        setContentView(binding.root)
    }
}