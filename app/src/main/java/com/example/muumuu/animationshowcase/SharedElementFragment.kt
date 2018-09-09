package com.example.muumuu.animationshowcase

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_shared_element.*

class SharedElementFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shared_element, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            recycler.layoutManager = GridLayoutManager(context, 2)
            recycler.adapter = SharedElementAdapter(context!!, { position, view ->
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity as Activity, Pair(view, SharedElementActivity.IMAGE_TRANSITION_NAME)
                )
                SharedElementActivity.startIntent(context!!, position, options.toBundle())
            })
        }
        viewCodeButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(CodeSampleUrl.SHARED_ELEMENT.url)))
        }

    }

    private class SharedElementAdapter(val context: Context,
                                       val onItemSelected: (Int, View) -> Unit)
        : RecyclerView.Adapter<SharedElementViewHolder>() {

        private val clickListener = View.OnClickListener {
            onItemSelected(it.getTag(R.id.position) as Int, it)

        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                SharedElementViewHolder(parent, context, clickListener)

        override fun onBindViewHolder(holder: SharedElementViewHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount() = IMAGE_LIST.size
    }

    private class SharedElementViewHolder(parent: ViewGroup,
                                          val context: Context,
                                          val clickListener: View.OnClickListener)
        : RecyclerView.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.view_shared_element_item,
                    parent, false)) {
        private val image = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(position: Int) {
            Glide.with(context).load(IMAGE_LIST[position])
                    .into(image)
            itemView.setTag(R.id.position, position)
            itemView.setOnClickListener(clickListener)
            ViewCompat.setTransitionName(itemView, "image-$position")
        }
    }

}