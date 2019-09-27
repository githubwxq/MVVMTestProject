package com.example.mvvmtestproject;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class MyAdapter {
    @BindingAdapter({"background"})
    public static void setBackground(View view, int id){
        view.setBackground(view.getResources().getDrawable(id));


    }

}
