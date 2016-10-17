package com.ett.csz.huacheng.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.base.BaseActivity;
import com.ett.csz.huacheng.entry.UserEntity;
import com.ett.csz.huacheng.util.StringUtil;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

public class LoginActivity extends BaseActivity {
    private AlertDialog alertDialog;
    private EditText username;
    private EditText password;
    private String cardNumStr;
    private String passwordStr;
    private CheckBox remember;
    private SharedPreferences sp;
    //命名空间
    private static final String NAMESPACE = "http://tempuri.org/";
    //服务地址
    private static String URL = "http://61.181.128.237:8091/webserver/ValideWebService.asmx";
    //调用的方法名
    private static final String METHOD_NAME = "Login";
    //此处是命名空间+方法名
    private static String SOAP_ACTION = "http://tempuri.org/Login";
    private SoapObject  detail;


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

    /**
     * 按钮点击事件
     * @param v
     */
    public  void buttonClick(View v){
        if (v.getId() == R.id.exit){
            System.exit(0);
        }
        if (v.getId() == R.id.login){
            cardNumStr = username.getText().toString();
            passwordStr = password.getText().toString();
            if(StringUtil.replaceBlank(cardNumStr)==null||StringUtil.replaceBlank(cardNumStr).length()<=0){
                Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if(StringUtil.replaceBlank(passwordStr)==null||StringUtil.replaceBlank(passwordStr).length()<=0){
                Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            alertDialog=showProgressDialog("登陆中...");
            new Thread() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub  
                    super.run();
                    try {
                        SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
                        //此处2个propertyinfo,是Login方法所需的参数，代码下面贴出asmx代码
                        PropertyInfo pi = new PropertyInfo();
                        pi.setName("loginName");
                        pi.setValue(cardNumStr);
                        rpc.addProperty(pi);
                        pi=new PropertyInfo();
                        pi.setName("passowrd");
                        pi.setValue(passwordStr);
                        rpc.addProperty(pi);
                        //soapheader在这里
                        Element[] header = new Element[1];
                        header[0] = new Element().createElement(NAMESPACE, "MySoapHeader");
                        Element username = new Element().createElement(NAMESPACE, "ProjectID");
                        username.addChild(Node.TEXT, "9c3e9154-b264-4662-b46b-a35f3b98ee59");
                        header[0].addChild(Node.ELEMENT, username);
                        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                        envelope.headerOut = header;
                        envelope.bodyOut = rpc;
                        envelope.dotNet = true;
                        envelope.setOutputSoapObject(rpc);
                        HttpTransportSE ht = new HttpTransportSE(URL);
                        ht.call(SOAP_ACTION, envelope);
                        //此处如果用soapobject会报错
                        detail =(SoapObject) envelope.getResponse();
                        System.out.println("返回的结果"+ detail.toString());
                    }catch (Exception e){
                        System.out.println("错误消息："+ e.getMessage());
                    }
                    Message msg = handler.obtainMessage();
                    msg.obj=detail;
                    handler.sendMessage(msg);
                }
            }.start();
        }
    }
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            UserEntity entities=new UserEntity();
            entities.setUserID(detail.getProperty(0).toString());
            entities.setLoginName(detail.getProperty(1).toString());
            entities.setChineseName(detail.getProperty(2).toString());
            entities.setJobNumber(detail.getProperty(3).toString());
            entities.setMobilePhone(detail.getProperty(4).toString());
            entities.setEmail(detail.getProperty(5).toString());
            entities.setQQ(detail.getProperty(6).toString());
            if(!entities.getUserID().equals("00000000-0000-0000-0000-000000000000")){
                if (remember.isChecked()){
                    //记住用户名、密码
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("USER_NAME",cardNumStr);
                    editor.putString("PASSWORD",passwordStr);
                    editor.commit();
                }
                Bundle bundle=new Bundle();
                bundle.putSerializable("userEntities",entities);
                openActivity(MainActivity.class,bundle);
            }else {
                Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
            }
        };
    };

}
