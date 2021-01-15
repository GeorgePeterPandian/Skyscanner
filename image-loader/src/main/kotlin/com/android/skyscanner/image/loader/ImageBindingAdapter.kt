package com.android.skyscanner.image.loader

import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("link")
fun loadImage(
    imageView: ImageView,
    id: String
) = with(imageView) {
    whenMeasured {
        loadImage(
            imageUrl = id.getImageUrl(),
            placeHolder = R.drawable.ic_no_image_40dp,
        )
    }
}

private fun View.whenMeasured(execution: () -> Unit) {
    viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            when {
                measuredWidth > 0 -> {
                    viewTreeObserver.removeOnPreDrawListener(this)
                    execution.invoke()
                }
            }
            return true
        }
    })
}