package com.example.mvvmtestproject;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyClick implements UserClickListener{

    private String tag="myclick";


    public   void test(View view){
        Toast.makeText(view.getContext(),"给你验证码",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void userClicked(View view) {

    }
}
