package com.example.muumuu.animationshowcase

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.view.ViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_shared_element.*

class SharedElementActivity : Activity() {
    companion object {
        const val IMAGE_TRANSITION_NAME = "image_transition"
        private const val KEY_POSITION = "position"
        fun startIntent(context: Context, position: Int, bundle: Bundle? = null) {
            context.startActivity(Intent(context, SharedElementActivity::class.java).apply {
                putExtra(KEY_POSITION, position)
            }, bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element)

        postponeEnterTransition()
        val url = IMAGE_LIST[intent.getIntExtra(KEY_POSITION, 0)]
        Glide.with(this)
                .load(url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?,
                                              model: Any?,
                                              target: Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        startPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?,
                                                 model: Any?,
                                                 target: Target<Drawable>?,
                                                 dataSource: DataSource?,
                                                 isFirstResource: Boolean): Boolean {
                        startPostponedEnterTransition()
                        return false
                    }
                })
                .into(image)
        ViewCompat.setTransitionName(image, IMAGE_TRANSITION_NAME)
        toolbar.title = "position ${intent.getIntExtra(KEY_POSITION, 0)}"
    }
}