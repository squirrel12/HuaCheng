package com.ett.csz.huacheng.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.adapter.FinishListAdapter;
import com.ett.csz.huacheng.adapter.UnFinishListAdapter;
import com.ett.csz.huacheng.mylistview.AutoListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategory extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_category, container, false);
        return view;

    }

}
