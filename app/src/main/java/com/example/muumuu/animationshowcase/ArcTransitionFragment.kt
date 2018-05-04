package com.example.muumuu.animationshowcase

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.transition.ArcMotion
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_arc_transition.*

class ArcTransitionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_arc_transition, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButton()
    }

    private fun setUpButton() {
        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(
                    heartContainer,
                    ChangeBounds().apply {
                        setPathMotion(ArcMotion())
                        duration = 1000L
                    }

            )

            val params = (heartContainer.layoutParams as ConstraintLayout.LayoutParams).apply {
                horizontalBias = if (horizontalBias == 0f) 1f else 0f
                verticalBias = if (verticalBias == 0.2f) 0.8f else 0.2f
            }
            heartContainer.layoutParams = params
        }
    }
}