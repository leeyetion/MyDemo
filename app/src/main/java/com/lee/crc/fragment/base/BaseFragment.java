package com.lee.crc.fragment.base;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lee.crc.R;
import com.lee.crc.activity.MainActivity;
import com.lee.crc.model.InformationItemData;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyesheng on 2017/1/17.
 */
public abstract class BaseFragment extends Fragment implements AdapterView.OnItemClickListener {

    protected static final String ARG_POSITION = "position";

    private ListView mListView;

    private TextView mEmptyView;
    protected View mOrderNull;
    protected boolean b = false;
    protected boolean hasFist = false;
    /**
     * 请求的页数
     */
    protected int page = 1;

    protected BaseAdapter baseAdapter;
    protected Handler mQueryHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void setAdapter();


    public void setEmptyViewVisable(int i) {
        mOrderNull.setVisibility(i);
    }




    protected int getLayoutId() {
        return R.layout.list_fragment;
    }

    protected void setupViews(View layout) {

    }
    protected void setupData() {
        b = true;
    }
}