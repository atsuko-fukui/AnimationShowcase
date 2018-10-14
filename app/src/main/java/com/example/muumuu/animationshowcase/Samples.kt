package com.example.muumuu.animationshowcase

import android.support.v4.app.Fragment

enum class Samples(val id: Int) {
    SCALE_BUTTON(R.id.nav_scale_button) {
        override fun newFragment() = ScaleButtonFragment()
    },
    SHARED_ELEMENT(R.id.nav_shared_element) {
        override fun newFragment() = SharedElementFragment()
    },
    ARC_TRANSITION(R.id.nav_arc_transition) {
        override fun newFragment() = ArcTransitionFragment()
    },
    STATE_LIST_ANIMATION(R.id.nav_state_list_animation) {
        override fun newFragment() = StateListAnimFragment()
    },
    REORDERING(R.id.nav_reordering_animation) {
        override fun newFragment() = ReorderingFragment()
    },
    SELECTABLE_ITEMS(R.id.nav_selectable_items) {
        override fun newFragment() = SelectableItemFragment()
    };


    abstract fun newFragment(): Fragment
}