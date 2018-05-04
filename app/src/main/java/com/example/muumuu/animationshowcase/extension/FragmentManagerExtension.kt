package com.example.muumuu.animationshowcase.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun FragmentManager.show(id: Int, fragment: Fragment, tag: String) {
    beginTransaction()
            .add(id, fragment, tag)
            .commit()
}

fun FragmentManager.replace(id: Int, fragment: Fragment, tag: String) {
    beginTransaction()
            .replace(id, fragment, tag)
            .commit()
}