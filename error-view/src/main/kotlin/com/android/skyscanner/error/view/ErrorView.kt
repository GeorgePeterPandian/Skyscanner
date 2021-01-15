package com.android.skyscanner.error.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.UiThread
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.android.skyscanner.error.view.databinding.ErrorViewBinding

class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var onRetryClickListener: (() -> Unit)? = null
    private lateinit var viewBinding: ErrorViewBinding

    init {
        if (!isInEditMode) {
            viewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.error_view,
                this,
                true
            )
            readAttributes(context, attrs)
            viewBinding.retry.setOnClickListener { onRetryClickListener?.invoke() }
        }
    }

    private fun readAttributes(context: Context, attributeSet: AttributeSet?) {
        with(
            context.theme.obtainStyledAttributes(attributeSet, R.styleable.errorView, 0, 0)
        ) {
            with(viewBinding) {
                title.text = getString(R.styleable.errorView_title)
                    ?: resources.getString(R.string.error_view_title_generic)

                subtitle.text = getString(R.styleable.errorView_subtitle)
                    ?: resources.getString(R.string.error_view_subtitle_generic)

                retry.text = getString(R.styleable.errorView_buttonText) ?: resources.getString(
                    R.string.error_view_retry
                )
            }

            recycle()
        }
    }

    fun setOnRetryClickListener(listener: () -> Unit) {
        onRetryClickListener = listener
    }

    @UiThread
    fun setTitle(text: String) {
        viewBinding.title.text = text
    }

    @UiThread
    fun setSubtitle(exception: String) {
        viewBinding.subtitle.text = exception
    }

}