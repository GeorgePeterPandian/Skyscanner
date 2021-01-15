package com.android.skyscanner.resources.common

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    with(this) {
        when {
            isFocused -> clearFocus()
        }
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(this.windowToken, 0)
    }
}