package com.paawk4.harrypotterapp.presentation.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class GridItemDecorator(
    private val horizontalSpacing: Int,
    private val verticalSpacing: Int,
    private val columnCount: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val column: Int = position % columnCount

        outRect.left = column * horizontalSpacing / columnCount
        outRect.right = horizontalSpacing - (column + 1) * horizontalSpacing / columnCount
        if (position >= columnCount) {
            outRect.top = verticalSpacing
        }
    }
}