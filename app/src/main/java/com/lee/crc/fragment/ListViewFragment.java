package com.lee.crc.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.crc.R;
import com.lee.crc.activity.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyesheng on 2017/1/17.
 */
public class ListViewFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;

    protected BaseAdapter baseAdapter;

    private List<String> mNewBeas = new ArrayList<String>();
    public static ListViewFragment newInstance(String s) {
        ListViewFragment f = new ListViewFragment();
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mNewBeas==null||mNewBeas.size()==0) {

            for (int i = 0; i < 30; i++) {
                mNewBeas.add("admin" + i);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(getLayoutId(), null);
        setupViews(contentView);
        return contentView;
    }

    /**
     * 获取布局文件
     *
     * @return
     */
    protected int getLayoutId(){

        return R.layout.list_fragment;
    }

    /**
     * 设置view
     *
     * @param view
     */
    protected void setupViews(View view){
        mListView = (ListView) view.findViewById(R.id.lv_content);
        mListView.setOnItemClickListener(this);
        baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mNewBeas.size();
            }

            @Override
            public Object getItem(int i) {
                return mNewBeas.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getActivity()).inflate(R.layout.list_fragment_item, null);
                }
                TextView infoDesc =(TextView)convertView.findViewById(R.id.tv_list_fragment_item_value);

                infoDesc.setText(mNewBeas.get(i));
                return convertView;
            }
        };
        mListView.setAdapter(baseAdapter);
    }

    /**
     * 设置数据
     */
    protected  void setupData(){

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("infomationBean", (Serializable) baseAdapter.getItem(i));
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}