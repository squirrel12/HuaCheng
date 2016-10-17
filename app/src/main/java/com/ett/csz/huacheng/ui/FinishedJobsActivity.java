package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.adapter.ListViewAdapter;
import com.ett.csz.huacheng.base.BaseActivity;
import com.ett.csz.huacheng.entry.JobEntry;
import com.ett.csz.huacheng.mylistview.AutoListView;
import com.ett.csz.huacheng.mylistview.AutoListView.OnRefreshListener;
import com.ett.csz.huacheng.mylistview.AutoListView.OnLoadListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.security.AccessController.getContext;

public class FinishedJobsActivity extends BaseActivity implements OnRefreshListener,OnLoadListener {
    private AutoListView lstv;
    private ListViewAdapter adapter;
    private List<String> list = new ArrayList<String>();
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            List<String> result = (List<String>) msg.obj;
            switch (msg.what) {
                case AutoListView.REFRESH:
                    lstv.onRefreshComplete();
                    list.clear();
                    list.addAll(result);
                    break;
                case AutoListView.LOAD:
                    lstv.onLoadComplete();
                    list.addAll(result);
                    break;
            }
            lstv.setResultSize(result.size());
            adapter.notifyDataSetChanged();
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_jobs);

        lstv = (AutoListView) findViewById(R.id.lstv);
        adapter = new ListViewAdapter(this, list);
        lstv.setAdapter(adapter);
        lstv.setOnRefreshListener(this);
        lstv.setOnLoadListener(this);
        initData();
        lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle mBundle = new Bundle();
                JobEntry entries = new JobEntry(null, null, null);
                mBundle.putSerializable("majorGoods", entries);
                openActivity(JobDetailsActivity.class, mBundle);
            }
        });
    }
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
        for (int i = 0; i < 15; i++) {
            long l = random.nextInt(10000);
            result.add("当前条目的ID：" + l);
        }
        return result;
    }
    public void onclickImage(View view){
        if(view.getId()==R.id.back4){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        if(view.getId()==R.id.searchView){
            Intent intent = new Intent(this, QueryJobsActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
