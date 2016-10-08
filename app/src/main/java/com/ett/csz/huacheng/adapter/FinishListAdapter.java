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
 * 已完成的工单搜索列表适配器
 * Created by csz on 2016/9/27.
 */

public class FinishListAdapter extends BaseAdapter {
    private FinishListAdapter.ViewHolder holder;
    private List<String> list;
    private Context context;

    public FinishListAdapter(Context context, List<String> list) {
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
            holder = new FinishListAdapter.ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_query_list, null);
            holder.text = (TextView) convertView.findViewById(R.id.textView19);
            convertView.setTag(holder);
        } else {
            holder = (FinishListAdapter.ViewHolder) convertView.getTag();
        }
        holder.text.setText(list.get(position));
        return convertView;
    }

    private static class ViewHolder {
        TextView text;
    }
}
