package com.example.mvvmtestproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;

public class UserBean  extends BaseObservable {

    public String name ;

    public String age ;


    public void setItemBean(ItemBean itemBean) {
        this.itemBean = itemBean;
    }


    @Bindable
    public ItemBean getItemBean() {
        return itemBean;
    }

    public ItemBean itemBean ;




    @Bindable
    public String getAvator() {
//        return "http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg";
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
      notifyPropertyChanged(BR.name);     //必须加了以后才会变
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age=age;
        notifyPropertyChanged(BR.age);
    }







}
