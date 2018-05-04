package com.example.muumuu.animationshowcase

import android.support.v4.app.Fragment

enum class Samples(val id: Int) {
    SCALE_BUTTON(R.id.nav_scale_button) {
        override fun newFragment() = ScaleButtonFragment()
    },
    ARC_TRANSITION(R.id.nav_arc_transition) {
        override fun newFragment() = ArcTransitionFragment()
    };

    abstract fun newFragment(): Fragment
}