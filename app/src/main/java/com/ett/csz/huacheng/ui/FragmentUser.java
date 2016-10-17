package com.ett.csz.huacheng.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ett.csz.huacheng.R;
import com.ett.csz.huacheng.entry.UserEntity;

/**
 * 用户中心
 */
public class FragmentUser extends Fragment {
    TextView chinsesname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        chinsesname= (TextView) view.findViewById(R.id.usernameview);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param");
            chinsesname.setText("mParam1");
        }
        chinsesname.setText("华澄用户");
        return view;
    }
    public static FragmentUser newInstance(String text) {
        FragmentUser fragment = new FragmentUser();
        Bundle args = new Bundle();
        args.putString("param", text);
        fragment.setArguments(args);
        return fragment;
    }
}
