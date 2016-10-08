package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ett.csz.huacheng.R;

public class QueryJobsActivity extends Activity {
    private EditText jobNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_jobs);
        init();
    }

    private void init() {
        jobNumber=(EditText)findViewById(R.id.editText);
    }

    public void onclickImage(View view){
        //返回
        if(view.getId()==R.id.back5){
            Intent intent = new Intent(this, FinishedJobsActivity.class);
            startActivity(intent);
            this.finish();
        }
        //查询
        if(view.getId()==R.id.submit_1){
            Intent intent = new Intent(this, JobListActivity.class);
            startActivity(intent);
            this.finish();
        }
        //重置
        if(view.getId()==R.id.reset_1){
            jobNumber.setText("");
        }
    }

}
