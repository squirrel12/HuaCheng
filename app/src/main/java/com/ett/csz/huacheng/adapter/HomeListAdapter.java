package com.ett.csz.huacheng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ett.csz.huacheng.R;

import java.util.List;

/**
 * 首页消息适配器
 * Created by csz on 2016/10/14.
 */

public class HomeListAdapter extends BaseAdapter {
    private HomeListAdapter.ViewHolder holder;
    private List<String> list;
    private Context context;

    public HomeListAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new HomeListAdapter.ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.listview_item, null);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (HomeListAdapter.ViewHolder) convertView.getTag();
        }
        holder.text.setText(list.get(position));
        return convertView;
    }

    private static class ViewHolder {
        TextView text;
    }
}
