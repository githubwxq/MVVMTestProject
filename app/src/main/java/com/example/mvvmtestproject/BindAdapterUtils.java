package com.example.mvvmtestproject;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindAdapterUtils {

    @BindingAdapter({"avator"})
    public static void abc(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }


    @BindingAdapter({"imageUrl", "placeDrawableId", "errorDrawableId"})
    public static void setImageUrl(ImageView imageView, String imageUrl, int placeDrawableId, int errorDrawableId) {
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(placeDrawableId).error(errorDrawableId);
    }


}
