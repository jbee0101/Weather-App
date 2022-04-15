package com.example.weatherapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun setImageViewResource(view: ImageView, resId : Int) {
    view.setImageResource(resId)
}
