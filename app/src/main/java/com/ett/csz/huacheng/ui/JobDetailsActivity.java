package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.base.BaseActivity;
import com.ett.csz.huacheng.entry.BaseEntity;

public class JobDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
    }
    public void onclickImage(View view){
        if(view.getId()==R.id.back7){
            openActivity(FinishedJobsActivity.class);
        }
    }
}
