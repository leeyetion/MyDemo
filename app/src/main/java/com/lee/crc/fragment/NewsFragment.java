package com.lee.crc.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
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
import com.lee.crc.model.People;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by liyesheng on 2017/1/17.
 */
public class NewsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;

    protected BaseAdapter baseAdapter;

    private List<People> mNewBeas = new ArrayList<People>();

    private Handler handler=new Handler(){

        @Override // 重写handlerMessage方法,用来处理Message消息
        public void handleMessage(Message msg) {}

    };
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            // TODO
            try {
            /*InputStream is = getActivity().getAssets().open("news.txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer, "UTF-8");*/

                URL url = new URL("http://10.66.50.30/pms/EmployeeImpl");
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    Log.i("mytag",inputLine);
                }
                in.close();

                Gson gson = new Gson();
                mNewBeas = gson.fromJson(inputLine, new TypeToken<List<People>>(){}.getType());
                for(int i = 0; i < mNewBeas.size() ; i++)
                {
                    People p = mNewBeas.get(i);
                    Log.i("mytag",p.toString());
                }

                Log.i("mytag",inputLine);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 在这里进行 http request.网络请求相关操作
            Message msg=handler.obtainMessage();
            handler.sendMessage(msg);
        }
    };



    public static NewsFragment newInstance(String s) {
        NewsFragment f = new NewsFragment();
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
        setupData();



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


            public long getItemId(int i) {
                return i;
            }


            public View getView(int i, View convertView, ViewGroup viewGroup) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getActivity()).inflate(R.layout.list_fragment_news_item, null);
                }
                People p = (People) getItem(i);
                TextView tv = (TextView)convertView.findViewById(R.id.infoTitle);
                tv.setText(p.getName());
                ImageView iv = (ImageView)convertView.findViewById(R.id.information_content_item_smallpic);
                TextView infoDesc = (TextView) convertView.findViewById(R.id.infoDesc);
                infoDesc.setText(p.getFrom());
                if (p.getUrl() != null) {
                    String url = p.getUrl();
                    ImageLoader loader=ImageLoader.getInstance();
                    loader.init(ImageLoaderConfiguration.createDefault(getActivity()));
                    loader.displayImage(url, iv);
                } else {
                    iv.setImageBitmap(null);
                    iv.setBackgroundResource(R.drawable.email);
                }
                // infoDate
                TextView infoDate = (TextView)convertView.findViewById(R.id.infoDate);
                infoDate.setText(p.getContent());
                return convertView;
            }
        };
        mListView.setAdapter(baseAdapter);
    }

    /**
     * 设置数据
     */
    protected  void setupData(){
        try {
            /*InputStream is = getActivity().getAssets().open("news.txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer, "UTF-8");*/

            URL url = new URL("http://10.66.50.30/pms/EmployeeImpl");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                Log.i("mytag",inputLine);
            }
            in.close();

            Gson gson = new Gson();
            mNewBeas = gson.fromJson(inputLine, new TypeToken<List<People>>(){}.getType());
            for(int i = 0; i < mNewBeas.size() ; i++)
            {
                People p = mNewBeas.get(i);
                Log.i("mytag",p.toString());
            }

            Log.i("mytag",inputLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
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