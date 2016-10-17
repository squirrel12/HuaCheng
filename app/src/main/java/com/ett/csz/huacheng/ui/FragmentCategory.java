package com.ett.csz.huacheng.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.adapter.UnFinishListAdapter;
import com.ett.csz.huacheng.entry.JobEntry;
import com.ett.csz.huacheng.mylistview.AutoListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 工单中心
 */
public class FragmentCategory extends ListFragment implements AutoListView.OnRefreshListener,AutoListView.OnLoadListener {
    private  View view;
    private AutoListView listview;
    private UnFinishListAdapter adapter;
    private List<String> list = new ArrayList<String>();
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            List<String> result = (List<String>) msg.obj;
            switch (msg.what) {
                case AutoListView.REFRESH:
                    listview.onRefreshComplete();
                    list.clear();
                    list.addAll(result);
                    break;
                case AutoListView.LOAD:
                    listview.onLoadComplete();
                    list.addAll(result);
                    break;
            }
            listview.setResultSize(result.size());
            adapter.notifyDataSetChanged();
        };
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_category, container, false);
        listview=(AutoListView)view.findViewById(android.R.id.list);
        adapter = new UnFinishListAdapter(getActivity(), list);
        listview.setAdapter(adapter);
        listview.setOnRefreshListener(this);
        listview.setOnLoadListener(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //// TODO: 2016/10/14 点击事件
                Intent intent=new Intent(getActivity(),EditJobActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("jobnumber","0010");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        initData();
        return view;
    }
    //初始化未完成工单列表
    private void initData() {
        loadData(AutoListView.REFRESH);
    }
    private void loadData(final int what) {
        // 这里模拟从服务器获取数据
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = handler.obtainMessage();
                msg.what = what;
                msg.obj = getData();
                handler.sendMessage(msg);
            }
        }).start();
    }
    // 测试数据
    public List<String> getData() {
        List<String> result = new ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            long l = random.nextInt(10000);
            result.add("当前条目的ID：" + l);
        }
        return result;
    }
    @Override
    public void onLoad() {

    }

    @Override
    public void onRefresh() {

    }
    
}
