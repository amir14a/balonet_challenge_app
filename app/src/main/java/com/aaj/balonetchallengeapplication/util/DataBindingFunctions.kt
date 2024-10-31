package com.aaj.balonetchallengeapplication.util

import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil3.load
import coil3.request.crossfade
import coil3.request.error
import coil3.request.placeholder
import coil3.size.Scale
import com.dede.blurhash_android.BlurHashDrawable

object DataBindingFunctions {

    @JvmStatic
    @BindingAdapter(value = ["app:imageUrl", "app:blurHashString"])
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

    @JvmStatic
    @BindingAdapter("app:customTextSize")
    fun setTextSize(textView: TextView, textSize: AppTextSizes) {
        var size = StaticParameters.appDefaultTextSize
        size += when (textSize) {
            AppTextSizes.VERY_SMALL -> -4
            AppTextSizes.SMALL -> 0
            AppTextSizes.NORMAL -> 4
            AppTextSizes.LARGE -> 8
            AppTextSizes.VERY_LARGE -> 10
        }
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }
}