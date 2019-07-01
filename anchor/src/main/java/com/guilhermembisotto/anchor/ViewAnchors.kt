package com.guilhermembisotto.anchor

import android.view.View
import android.view.ViewGroup

enum class ViewAnchors {
    ANCHOR_TOP, ANCHOR_BOTTOM, ANCHOR_LEFT, ANCHOR_RIGHT
}

class ViewAnchorModel(
    val anchor: View,
    val edgeToAnchor: ViewAnchors
)

fun processAnchors(
    view: View,
    anchors: List<ViewAnchorModel>
) {
    val layoutParams =
        view.layoutParams as ViewGroup.MarginLayoutParams

    var left = layoutParams.leftMargin
    var top = layoutParams.topMargin
    var right = layoutParams.rightMargin
    var bottom = layoutParams.bottomMargin

    anchors.forEach {
        when (it.edgeToAnchor) {
            ViewAnchors.ANCHOR_LEFT -> {
                left = it.anchor.right
            }
            ViewAnchors.ANCHOR_TOP -> {
                top = it.anchor.bottom
            }
            ViewAnchors.ANCHOR_RIGHT -> {
                right = it.anchor.left
            }
            ViewAnchors.ANCHOR_BOTTOM -> {
                bottom = it.anchor.top
            }
        }
    }
    setMargins(
        view,
        layoutParams,
        left,
        top,
        right,
        bottom
    )
}

private fun setMargins(
    view: View,
    layoutParams: ViewGroup.MarginLayoutParams,
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
) {
    layoutParams.setMargins(
        left,
        top,
        right,
        bottom
    )

    view.requestLayout()
}
//
// private fun animateFade(view: View) {
//     TransitionManager.beginDelayedTransition(view.parent as ViewGroup)
//     view.visibility = View.VISIBLE
// }
//
// private fun animatePosition(view: View) {
//     TransitionManager.beginDelayedTransition(view.parent as ViewGroup)
//     view.requestLayout()
// }
//
// private fun animatePositionAndFade(view: View) {
//     TransitionManager.beginDelayedTransition(view.parent as ViewGroup)
//     view.visibility = View.VISIBLE
//     view.requestLayout()
// }