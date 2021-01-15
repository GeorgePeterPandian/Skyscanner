package com.android.skyscanner.empty.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.android.skyscanner.empty.view.databinding.EmptyViewBinding

class EmptyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var viewBinding: EmptyViewBinding

    init {
        if (!isInEditMode) {
            viewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.empty_view,
                this,
                true
            )
            readAttributes(context, attrs)
        }
    }

    private fun readAttributes(context: Context, attributeSet: AttributeSet?) {
        with(
            context.theme.obtainStyledAttributes(
                attributeSet,
                R.styleable.emptyView,
                0,
                0
            )
        ) {
            with(viewBinding) {
                title.text = getString(R.styleable.emptyView_title)
                    ?: resources.getString(R.string.default_empty_title)

                subtitle.text =
                    getString(R.styleable.emptyView_subtitle)
                        ?: resources.getString(R.string.default_empty_subtitle)
            }
            recycle()
        }
    }
}