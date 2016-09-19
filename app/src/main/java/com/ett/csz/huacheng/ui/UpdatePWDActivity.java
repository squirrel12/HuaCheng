package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ett.csz.huacheng.R;

/**
 * 修改密码
 */
public class UpdatePWDActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
    }

    /**
     * 按钮点击事件
     * @param view
     */
    public void onclickImage(View view){
        if (view.getId()==R.id.back1){//点击返回按钮
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        if (view.getId()==R.id.cancel_btn){//点击取消按钮
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        if (view.getId()==R.id.submit_btn){
            //TODO 执行修改密码操作
        }
    }
}
