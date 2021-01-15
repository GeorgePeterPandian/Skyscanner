package com.android.skyscanner.image.loader

import okhttp3.HttpUrl

internal fun String.getImageUrl() =
    when {
        isEmpty() -> ""
        else -> HttpUrl
            .Builder()
            .scheme("https")
            .host(BuildConfig.IMAGES)
            .addPathSegment("images")
            .addPathSegment("airlines")
            .addPathSegment("small")
            .addPathSegment("$this.png")
            .build()
            .toString()
    }