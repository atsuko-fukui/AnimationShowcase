package com.example.muumuu.animationshowcase

import androidx.fragment.app.Fragment

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
    },
    CROP_TO_OUTLINE(R.id.nav_crop_to_outline) {
        override fun newFragment() = CropToOutlineFragment()
    },
    FLOW(R.id.nav_flow) {
        override fun newFragment() = FlowFragment()
    };

    abstract fun newFragment(): Fragment
}