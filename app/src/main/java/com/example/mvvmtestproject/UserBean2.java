package com.example.mvvmtestproject;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class UserBean2 extends BaseObservable {

    public String name ;

    public String age ;

    @Bindable
    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
        notifyPropertyChanged(BR.avator);
    }

    public String avator ;

    @Bindable
    public MyClick getClick() {
        return click;
    }

    public void setClick(MyClick click) {
        this.click = click;
        notifyPropertyChanged(BR.click);
    }

    public MyClick click ;


    @Bindable
    public String getName() {
        return  name;
    }

    public void setName(String name) {
      this.name=name;
      notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age=age;
        notifyPropertyChanged(BR.age);
    }



   @BindingAdapter({"avator"})
    public static  void abc(ImageView view,String url){
       Glide.with(view.getContext()).load(url).into(view);
    }





}
