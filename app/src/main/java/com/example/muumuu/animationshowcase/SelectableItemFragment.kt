package com.example.muumuu.animationshowcase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_selectable_item.*

class SelectableItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selectable_item, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        background_borderless.setOnClickListener {  }
        background_border.setOnClickListener {  }
        foreground_borderless.setOnClickListener {  }
        foreground_border.setOnClickListener {  }


        viewCodeButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(CodeSampleUrl.SELECTED_ITEMS.url)))
        }
    }
}