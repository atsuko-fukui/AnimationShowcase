package com.example.muumuu.animationshowcase.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun FragmentManager.addFragment(id: Int, fragment: Fragment) {
    beginTransaction()
            .add(id, fragment)
            .commit()
}