package com.example.muumuu.animationshowcase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_shared_element.recycler

class ReorderingActivity : AppCompatActivity() {
    companion object {
        const val IMAGE_TRANSITION_NAME = "image_transition"

        fun start(context: Context, bundle: Bundle? = null) {
            context.startActivity(Intent(context, ReorderingActivity::class.java), bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reordering)
        postponeEnterTransition()

        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = ReorderingFragment.ReorderingAdapter(this)
    }
}