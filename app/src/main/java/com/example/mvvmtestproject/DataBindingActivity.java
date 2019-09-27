package com.example.mvvmtestproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmtestproject.databinding.ActivityMainBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class DataBindingActivity extends AppCompatActivity {
//    UserBean userBean=new UserBean();
    ActivityMainBinding activityMainBinding;
    TestViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
//        userBean.setName("wxq");
//        userBean.setAge("18");
//        userBean.setAvator("http://img3.imgtn.bdimg.com/it/u=1998053170,2487338721&fm=26&gp=0.jpg");
//
//
//        userBean.setClick(new MyClick());
//
//
//        activityMainBinding.tvName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                userBean.setAge("110000");
//                Toast.makeText(DataBindingActivity.this,userBean.getAge(), Toast.LENGTH_SHORT).show();
//            }
//        });

        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        viewModel.getuserbean().getValue();

        RxPermissions rxPermissions=new RxPermissions(this);

        rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION
                , Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
//                activityMainBinding.setUserBean(userBean);
                activityMainBinding.setUserBean(  viewModel.getuserbean().getValue());
                activityMainBinding.setUserBean2(  viewModel.getuserbean2().getValue());
            }
        });
//        Glide.with(this).load(userBean.getAvator()).into(activityMainBinding.tvHeard);
        activityMainBinding.tvHeard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                userBean.setAvator("http://img5.imgtn.bdimg.com/it/u=400225805,527616426&fm=26&gp=0.jpg");
            }
        });

    }
}
