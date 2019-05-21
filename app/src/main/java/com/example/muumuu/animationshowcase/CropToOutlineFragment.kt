package com.example.muumuu.animationshowcase

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_to_outline.*

class CropToOutlineFragment : Fragment() {

    companion object {
        private const val IMAGE_URL = "https://3.bp.blogspot.com/-YtrWSqttYsQ/WM9XglY6dtI/AAAAAAABCrE/FKxvLU_Dllkg7PN1RV8xSys-7M86MS1vwCLcB/s800/bg_digital_pattern_green.jpg"
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_to_outline, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        container.clipToOutline = true

        context?.let {
            Glide.with(it)
                    .load(IMAGE_URL)
                    .apply(RequestOptions().centerCrop())
                    .into(image)
        }
    }
}