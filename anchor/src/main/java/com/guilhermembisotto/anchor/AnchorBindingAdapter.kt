package com.guilhermembisotto.anchor

import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.databinding.BindingAdapter

@BindingAdapter(
    "app:anchorLeft",
    "app:anchorTop",
    "app:anchorRight",
    "app:anchorBottom",
    requireAll = false
)
fun View.setAnchors(
    anchorLeft: View? = null,
    anchorTop: View? = null,
    anchorRight: View? = null,
    anchorBottom: View? = null
) {
    val anchorList: MutableList<ViewAnchorModel> = mutableListOf()
    anchorLeft?.run {
        anchorList.add(
            ViewAnchorModel(
                this@run,
                ViewAnchors.ANCHOR_LEFT
            )
        )
    }
    anchorTop?.run {
        anchorList.add(
            ViewAnchorModel(
                this@run,
                ViewAnchors.ANCHOR_TOP
            )
        )
    }
    anchorRight?.run {
        anchorList.add(
            ViewAnchorModel(
                this@run,
                ViewAnchors.ANCHOR_RIGHT
            )
        )
    }
    anchorBottom?.run {
        anchorList.add(
            ViewAnchorModel(
                this@run,
                ViewAnchors.ANCHOR_BOTTOM
            )
        )
    }

    this.doOnPreDraw {
        processAnchors(
            it,
            anchorList
        )
    }
}