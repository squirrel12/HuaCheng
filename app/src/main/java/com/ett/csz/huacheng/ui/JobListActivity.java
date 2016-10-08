package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.adapter.FinishListAdapter;
import com.ett.csz.huacheng.adapter.ListViewAdapter;
import com.ett.csz.huacheng.mylistview.AutoListView;
import com.ett.csz.huacheng.mylistview.AutoListView.OnRefreshListener;
import com.ett.csz.huacheng.mylistview.AutoListView.OnLoadListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JobListActivity extends Activity implements OnRefreshListener, OnLoadListener {
    private AutoListView finish_list;
    private FinishListAdapter adapter;
    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        finish_list = (AutoListView) findViewById(R.id.finish_query_list);
        adapter = new FinishListAdapter(this, list);
        finish_list.setAdapter(adapter);
        finish_list.setOnRefreshListener(this);
        finish_list.setOnLoadListener(this);
        initData();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            List<String> result = (List<String>) msg.obj;
            switch (msg.what) {
                case AutoListView.REFRESH:
                    finish_list.onRefreshComplete();
                    list.clear();
                    list.addAll(result);
                    break;
                case AutoListView.LOAD:
                    finish_list.onLoadComplete();
                    list.addAll(result);
                    break;
            }
            finish_list.setResultSize(result.size());
            adapter.notifyDataSetChanged();
        }

        ;
    };

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

    @Override
    public void onRefresh() {
        loadData(AutoListView.REFRESH);
    }

    @Override
    public void onLoad() {
        loadData(AutoListView.LOAD);
    }

    // 测试数据
    public List<String> getData() {
        List<String> result = new ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            long l = random.nextInt(10000);
            result.add("当前条目的ID：" + l);
        }
        return result;
    }

    public void onclickImage(View view) {
        if (view.getId() == R.id.back6) {
            Intent intent = new Intent(this, QueryJobsActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
