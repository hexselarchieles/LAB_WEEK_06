package com.example.lab_week_06

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader(activity: MainActivity) : ImageLoader {
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}
