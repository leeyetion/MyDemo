package com.lee.crc.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lee.crc.R;
import com.lee.crc.activity.fragment.FragmentDemo1Activity;
import com.lee.crc.activity.fragment.FragmentDemo2Activity;
import com.lee.crc.activity.recycler.RecyclerViewDemo1;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goFragmentDemo1(View view){
        Intent intent =new Intent();
        intent.setClass(this, FragmentDemo1Activity.class);
        startActivity(intent);

    }
    public void goFragmentDemo2(View view){
        Intent intent =new Intent();
        intent.setClass(this, FragmentDemo2Activity.class);
        startActivity(intent);
    }

    public void goRecyclerViewDemo1(View view){
        Intent intent =new Intent();
        intent.setClass(this, RecyclerViewDemo1.class);
        startActivity(intent);
    }
}
