package com.ett.csz.huacheng.ui;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.ett.csz.huacheng.R;

/**
 * 用户信息
 */
public class UserCenterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
    }

    /**
     * 点击事件
     * @param view
     */
    public void onclickImage(View view) {
        if(view.getId()== R.id.back2){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
