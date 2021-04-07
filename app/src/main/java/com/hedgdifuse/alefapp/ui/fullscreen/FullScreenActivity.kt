package com.hedgdifuse.alefapp.ui.fullscreen

import android.os.Bundle
import com.hedgdifuse.alefapp.base.BaseBindingActivity
import com.hedgdifuse.alefapp.databinding.ActivityFullScreenBinding

class FullScreenActivity: BaseBindingActivity<ActivityFullScreenBinding>(
    ActivityFullScreenBinding::inflate
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get image url from extras and load
        binding.fullImage.setImageURI(intent.extras?.getString("image"))

        // Add navigation icon listener
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}