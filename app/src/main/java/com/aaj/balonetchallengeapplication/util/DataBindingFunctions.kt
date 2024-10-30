package com.aaj.balonetchallengeapplication.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil3.load
import coil3.request.crossfade
import coil3.request.error
import coil3.request.placeholder
import coil3.size.Scale
import com.dede.blurhash_android.BlurHashDrawable

object DataBindingFunctions {

    @JvmStatic
    @BindingAdapter(value = ["bind:imageUrl", "bind:blurHashString"])
    fun setImage(imageView: ImageView, url: String?, blurHashString: String?) {
        if (!url.isNullOrBlank())
            imageView.load(url) {
                crossfade(500)
                scale(Scale.FILL)
                if (!blurHashString.isNullOrBlank()) {
                    val blurHashDrawable = BlurHashDrawable(blurHashString)
                    placeholder(blurHashDrawable)
                    error(blurHashDrawable as Drawable)
                }
            }
    }
}