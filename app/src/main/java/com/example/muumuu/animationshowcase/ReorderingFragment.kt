package com.example.muumuu.animationshowcase

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat.startPostponedEnterTransition
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.muumuu.animationshowcase.ReorderingActivity.Companion.IMAGE_TRANSITION_NAME
import kotlinx.android.synthetic.main.fragment_reordering.fab
import kotlinx.android.synthetic.main.fragment_reordering.recycler
import kotlinx.android.synthetic.main.fragment_reordering.viewCodeButton

class ReorderingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reordering, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            recycler.layoutManager = GridLayoutManager(context, 2)
            recycler.adapter = ReorderingAdapter(activity!!)
        }
        viewCodeButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(CodeSampleUrl.REORDERING_ANIMATION.url)))
        }
        fab.setOnClickListener {
            context?.let {
                val itemList = mutableListOf<Pair<View, String>>()
                (recycler.adapter as? ReorderingAdapter)?.items?.forEachIndexed { index, view ->
                    itemList.add(Pair(view, IMAGE_TRANSITION_NAME + index))
                }

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as Activity, *itemList.toTypedArray()
                ).toBundle()
                ReorderingActivity.start(it, options)
            }
        }
    }

    class ReorderingAdapter(private val activity: Activity)
        : RecyclerView.Adapter<ReorderingViewHolder>() {

        val items = mutableListOf<ImageView>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ReorderingViewHolder(parent, activity)

        override fun onBindViewHolder(holder: ReorderingViewHolder, position: Int) {
            holder.bind(position)
            if (!items.contains(holder.image)) {
                items.add(holder.image)
            }
        }

        override fun getItemCount() = IMAGE_LIST.size
    }

    class ReorderingViewHolder(parent: ViewGroup, private val activity: Activity)
        : RecyclerView.ViewHolder(
        LayoutInflater.from(activity).inflate(R.layout.view_shared_element_item,
            parent, false)) {
        val image: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(position: Int) {
            Glide.with(activity).load(IMAGE_LIST[position])
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?,
                                              model: Any?,
                                              target: Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        startPostponedEnterTransition(activity)
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?,
                                                 model: Any?,
                                                 target: Target<Drawable>?,
                                                 dataSource: DataSource?,
                                                 isFirstResource: Boolean): Boolean {
                        startPostponedEnterTransition(activity)
                        return false
                    }
                })
                .into(image)
            itemView.setTag(R.id.position, position)
            ViewCompat.setTransitionName(image, IMAGE_TRANSITION_NAME + position)
        }
    }
}