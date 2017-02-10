package com.lee.crc.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.crc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyesheng on 2017/1/17.
 */
public class ContentFragment extends Fragment {
    private String s;
    public void setS(String s){
        this.s=s;
    }
    private ListView lv_infor_list;
    private List<String> mNewBeas = new ArrayList<String>();
    public static ContentFragment newInstance(String s) {
        ContentFragment f = new ContentFragment();
//        Bundle b = new Bundle();
//        b.putString("postion", s);
//        // b.putInt(ARG_POSITION, pos);
//        f.setArguments(b);
        f.setS(s);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i=0;i<30;i++){
            mNewBeas.add("admin"+i);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_content, container, false);
        TextView tv= (TextView)contentView.findViewById(R.id.tv_content);

        tv.setText(s);

        return contentView;
    }
}