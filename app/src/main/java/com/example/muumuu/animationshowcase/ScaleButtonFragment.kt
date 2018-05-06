package com.example.muumuu.animationshowcase

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import kotlinx.android.synthetic.main.fragment_scale_button.*
import kotlin.properties.Delegates

class ScaleButtonFragment : Fragment() {

    private var isFabActivated by Delegates.observable(false) { _, _, new ->
        if (new) {
            fab.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(context!!, R.color.colorAccent))
            fab.setImageResource(R.drawable.ic_favorite_black_24dp)
            fab.imageTintList = ColorStateList.valueOf(Color.WHITE)

        } else {
            fab.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
            fab.setImageResource(R.drawable.ic_favorite_border_black_24dp)
            fab.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(context!!, R.color.colorAccent))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scale_button, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpFab(fab)
        viewCodeButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(CodeSampleUrl.SCALE_BUTTON.url)))
        }
    }

    private fun setUpFab(fab: FloatingActionButton) {
        fab.setOnClickListener {
            if (isFabActivated) {
                animateFab(doOnEnd = {
                    isFabActivated = false
                })
            } else {
                animateFab(doOnStart = {
                    isFabActivated = true
                })
            }
        }
        isFabActivated = false
    }

    private fun animateFab(doOnStart:(() -> Unit)? = null, doOnEnd:(() -> Unit)? = null) {
        val placeholderX = PropertyValuesHolder.ofFloat(View.SCALE_X,  1.5f, 1.0f)
        val placeholderY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.5f, 1.0f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(fab, placeholderX, placeholderY)
        animator.doOnStart {
            doOnStart?.invoke()
        }
        animator.doOnEnd {
            doOnEnd?.invoke()
        }
        animator.start()
    }
}