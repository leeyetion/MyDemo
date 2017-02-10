package com.lee.crc.activity.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;


import com.lee.crc.R;
import com.lee.crc.fragment.ContentFragment;


public class FragmentDemo1Activity extends Activity implements View.OnClickListener {
    private ImageView tab_bottom_viewgallery;
    private ImageView tab_bottom_email;
    private ImageView tab_bottom_account;

    private ContentFragment viewgallery;
    private ContentFragment email;
    private ContentFragment account;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragmentdemo1);

        tab_bottom_viewgallery=(ImageView)findViewById(R.id.tab_bottom_viewgallery);
        tab_bottom_email=(ImageView)findViewById(R.id.tab_bottom_email);
        tab_bottom_account=(ImageView)findViewById(R.id.tab_bottom_account);
        tab_bottom_viewgallery.setOnClickListener(FragmentDemo1Activity.this);
        tab_bottom_email.setOnClickListener(this);
        tab_bottom_account.setOnClickListener(this);
        setDefaultFragment();

    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        account =ContentFragment.newInstance("ccccccc");
        transaction.replace(R.id.id_content, account);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        switch (view.getId())
        {
            case R.id.tab_bottom_viewgallery:
                if (viewgallery == null)
                {
                    viewgallery = ContentFragment.newInstance("viewgallery");
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, viewgallery);
                break;
            case R.id.tab_bottom_email:
                if (email == null)
                {
                    email = ContentFragment.newInstance("email");
                }
                transaction.replace(R.id.id_content, email);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();

    }

}
