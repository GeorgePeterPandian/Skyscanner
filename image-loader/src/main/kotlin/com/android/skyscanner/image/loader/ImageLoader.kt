package com.android.skyscanner.image.loader

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.android.skyscanner.network.common.getCommonOkHttp
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

@JvmOverloads
fun ImageView.loadImage(
    imageUrl: String,
    @DrawableRes placeHolder: Int,
    @DrawableRes errorImage: Int = placeHolder
) {
    initPicasso(context)
    when {
        imageUrl.isEmpty() -> setImageResource(errorImage)
        else ->
            Picasso.with(context)
                .load(imageUrl)
                .placeholder(placeHolder)
                .error(errorImage)
                .into(this)
    }
}

var picassoIsNotInitialised = true

fun initPicasso(context: Context) {
    if (picassoIsNotInitialised) {
        val picasso = Picasso.Builder(context)
            .loggingEnabled(BuildConfig.DEBUG)
            .downloader(OkHttp3Downloader(getCommonOkHttp(BuildConfig.DEBUG)))
            .build()

        try {
            picassoIsNotInitialised = false
            Picasso.setSingletonInstance(picasso)
        } catch (ignored: IllegalStateException) {
            picassoIsNotInitialised = false
        }
    }
}