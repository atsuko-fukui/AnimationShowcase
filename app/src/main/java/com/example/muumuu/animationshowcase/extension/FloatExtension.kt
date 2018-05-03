package com.example.muumuu.animationshowcase.extension

import android.content.Context

fun Float.convertToPx(context: Context): Float {
    val metrics = context.resources.displayMetrics
    return this * metrics.density
}