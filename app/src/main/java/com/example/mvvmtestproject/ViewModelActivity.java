package com.example.mvvmtestproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewModelActivity extends AppCompatActivity implements View.OnClickListener {
    TestViewModel viewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);


        viewModel.getElapsedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                textView = findViewById(R.id.text);
                textView.setText(aLong + "时间过去了"); //手动设置的 希望自动
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
