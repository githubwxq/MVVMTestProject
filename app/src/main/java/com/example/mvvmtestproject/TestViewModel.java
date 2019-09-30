package com.example.mvvmtestproject;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TestViewModel extends ViewModel {

    private static final int ONE_SECOND = 3000;



    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();

    private MutableLiveData<UserBean> userBeanMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<UserBean2> userBean2MutableLiveData = new MutableLiveData<>();





    private long mInitialTime;

    public TestViewModel() {
        UserBean userBean = new UserBean();
        userBean.setName("wxq");
        userBean.setAge("18");

        userBeanMutableLiveData.setValue(userBean);

        UserBean2 userBean2 = new UserBean2();
        userBean2.setName("UserBean2wxq");
        userBean2.setAge("UserBean218");
        userBean2MutableLiveData.setValue(userBean2);


        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                mElapsedTime.postValue(newValue);
                UIHandler.getInstance().post(new Runnable() {
                    @Override
                    public void run() {

                        ItemBean itemBean=new ItemBean();
                        itemBean.setName(" ===name change"+newValue);
                        itemBean.setAge("===change"+newValue);
                        itemBean.setAvator("===change"+newValue);
                        //设置属性了然后变化了
                        userBeanMutableLiveData.getValue().setName(newValue + "看我的名字在变化"+newValue);
                        userBeanMutableLiveData.getValue().setItemBean(itemBean);

                        userBeanMutableLiveData.postValue( userBeanMutableLiveData.getValue());








                        userBean2MutableLiveData.getValue().setName(newValue + "看userbean我的名字在变化"+newValue);






                    }
                });
            }
        }, ONE_SECOND, ONE_SECOND);



    }

    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }

    public LiveData<UserBean> getuserbean() {
        return userBeanMutableLiveData;
    }


    public LiveData<UserBean2> getuserbean2() {
        return userBean2MutableLiveData;
    }


}
