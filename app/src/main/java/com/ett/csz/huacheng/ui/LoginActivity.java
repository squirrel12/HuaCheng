package com.ett.csz.huacheng.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ett.csz.huacheng.R;

public class LoginActivity extends Activity {
    private EditText username;
    private EditText password;
    private String cardNumStr;
    private String passwordStr;
    private CheckBox remember;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init(){
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        sp=this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        remember=(CheckBox)findViewById(R.id.checkBox);
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (remember.isChecked()){
                    System.out.println("记住密码已选中");
                    sp.edit().putBoolean("ISCHECK",true).commit();
                }else {
                    System.out.println("记住密码没有选中");
                    sp.edit().putBoolean("ISCHECK",false).commit();
                }
            }
        });
        //判断记住密码多选框的状态
        if(sp.getBoolean("ISCHECK",false)){
            remember.setChecked(true);
            username.setText(sp.getString("USER_NAME",""));
            password.setText(sp.getString("PASSWORD",""));
        }
    }
    public void buttonClick(View v){
        if (v.getId() == R.id.login){
            cardNumStr = username.getText().toString();
            passwordStr = password.getText().toString();
            if (!((cardNumStr.equals("test")) && (passwordStr.equals("123456")))) {
                Toast.makeText(LoginActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
            }else{
                //登录成功和记住密码框为选中状态才保存用户信息
                if (remember.isChecked()){
                    //记住用户名、密码
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("USER_NAME",cardNumStr);
                    editor.putString("PASSWORD",passwordStr);
                    editor.commit();
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
            }
        }
        if (v.getId() == R.id.exit){
            System.exit(0);
        }
    }
}
