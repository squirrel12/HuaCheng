package com.ett.csz.huacheng.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.WindowManager;

import com.ett.csz.huacheng.R;

import java.lang.reflect.Field;

public class BaseActivity extends Activity {
    protected AlertDialog mAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    protected void openActivity(String pAction) {
        openActivity(pAction, null);
    }

    protected void openActivity(String pAction, Bundle pBundle) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }
    /**
     * 通过反射来设置对话框是否要关闭，在表单校验时很管用， 因为在用户填写出错时点确定时默认Dialog会消失， 所以达不到校验的效果
     * 而mShowing字段就是用来控制是否要消失的，而它在Dialog中是私有变量， 所有只有通过反射去解决此问题
     *
     * @param pDialog
     * @param pIsClose
     */
    public void setAlertDialogIsClose(DialogInterface pDialog, Boolean pIsClose) {
        try {
            Field field = pDialog.getClass().getSuperclass().getDeclaredField("mShowing");
            field.setAccessible(true);
            field.set(pDialog, pIsClose);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected AlertDialog showAlertDialog(String TitleID, String Message) {
        mAlertDialog = new AlertDialog.Builder(this).setTitle(TitleID).setMessage(Message).show();
        return mAlertDialog;
    }

    protected AlertDialog showAlertDialog(int pTitelResID, String pMessage,
                                          DialogInterface.OnClickListener pOkClickListener) {
        String title = getResources().getString(pTitelResID);
        return showAlertDialog(title, pMessage, pOkClickListener, null, null);
    }

    protected AlertDialog showAlertDialog(String pTitle, String pMessage,
                                          DialogInterface.OnClickListener pOkClickListener, DialogInterface.OnClickListener pCancelClickListener,
                                          DialogInterface.OnDismissListener pDismissListener) {
        mAlertDialog = new AlertDialog.Builder(this).setTitle(pTitle).setMessage(pMessage)
                .setPositiveButton(android.R.string.ok, pOkClickListener)
                .setNegativeButton(android.R.string.cancel, pCancelClickListener).show();
        if (pDismissListener != null) {
            mAlertDialog.setOnDismissListener(pDismissListener);
        }
        return mAlertDialog;
    }

    protected AlertDialog showAlertDialog(String pTitle, String pMessage, String pPositiveButtonLabel,
                                          String pNegativeButtonLabel, DialogInterface.OnClickListener pOkClickListener,
                                          DialogInterface.OnClickListener pCancelClickListener, DialogInterface.OnDismissListener pDismissListener) {
        mAlertDialog = new AlertDialog.Builder(this).setTitle(pTitle).setMessage(pMessage)
                .setPositiveButton(pPositiveButtonLabel, pOkClickListener)
                .setNegativeButton(pNegativeButtonLabel, pCancelClickListener).show();
        if (pDismissListener != null) {
            mAlertDialog.setOnDismissListener(pDismissListener);
        }
        return mAlertDialog;
    }

    protected ProgressDialog showProgressDialog(int pTitelResID, String pMessage,
                                                DialogInterface.OnCancelListener pCancelClickListener) {
        String title = getResources().getString(pTitelResID);
        return showProgressDialog(title, pMessage, pCancelClickListener);
    }

    protected ProgressDialog showProgressDialog(String pTitle, String pMessage,
                                                DialogInterface.OnCancelListener pCancelClickListener) {
        mAlertDialog = ProgressDialog.show(this, pTitle, pMessage, true, true);
        mAlertDialog.setOnCancelListener(pCancelClickListener);
        return (ProgressDialog) mAlertDialog;
    }
    protected ProgressDialog showProgressDialog(String pMessage) {
        ProgressDialog progressDialog = new ProgressDialog(this,R.style.alert_dialog);
        progressDialog.setMessage(pMessage);
        progressDialog.setCancelable(true);// 不可以用“返回键”取消-false
        progressDialog.setCanceledOnTouchOutside(false);// 点击屏幕不消失
        WindowManager.LayoutParams params = progressDialog.getWindow().getAttributes();
        progressDialog.getWindow().setGravity(Gravity.BOTTOM);
        params.y = 100;//距离屏幕底部大小
        progressDialog.getWindow().setAttributes(params);
        progressDialog.show();
        return progressDialog;
    }
}
