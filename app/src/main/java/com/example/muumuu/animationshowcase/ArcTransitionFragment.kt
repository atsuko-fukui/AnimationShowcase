package com.example.muumuu.animationshowcase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import androidx.fragment.app.Fragment
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
        viewCodeButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(CodeSampleUrl.ARC_TRANSITION.url)))
        }

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