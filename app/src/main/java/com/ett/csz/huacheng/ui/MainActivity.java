package com.ett.csz.huacheng.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.entry.UserEntity;

/**
 * 主页
 * author csz
 */
public class MainActivity extends FragmentActivity  {
    private UserEntity userEntity;

    /************************工单未完成列表******************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEntity=(UserEntity)getIntent().getSerializableExtra("userEntities");
        //适配列表
        initTab();
    }



    /*********************************************************************/
    // 定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    // 定义一个布局
    private LayoutInflater layoutInflater;
    // 定义数组来存放Fragment界面
    private Class fragmentArray[] = {FragmentHome.class,
            FragmentCategory.class, FragmentUser.class};
    // 定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.main_tab_item_home, R.drawable.main_tab_item_category, R.drawable.main_tab_item_user};
    // Tab选项卡的文字
    private String mTextviewArray[] = {"主页", "工单", "我"};



    private void initTab() {

        /****************以下是底部选项卡有关*******************/
        // 实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        // 实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        // 得到fragment的个数
        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            // 为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i])
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.main_tab_item_bg);
        }
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }

    /*
    * 点击事件
     */
    public void onclickLayout(View view) {
        if (view.getId() == R.id.exitapp) {
            System.exit(0);
        }
        if(view.getId()==R.id.myinfo){
            Intent intent = new Intent(this, UserCenterActivity.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.button){//打开已完成的工单
            Intent intent = new Intent(this, FinishedJobsActivity.class);
            startActivity(intent);
        }
    }

}
