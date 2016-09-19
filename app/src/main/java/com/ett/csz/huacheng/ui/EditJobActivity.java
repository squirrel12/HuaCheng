package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ett.csz.huacheng.R;

/**
 * 工单编辑
 */
public class EditJobActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_job);
    }

    public void onclickImage(View view) {
        if(view.getId()==R.id.back3){
            //TODO 返回上级页面
        }
    }
}
