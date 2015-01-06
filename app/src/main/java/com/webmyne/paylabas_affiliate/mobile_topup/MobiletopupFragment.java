package com.webmyne.paylabas_affiliate.mobile_topup;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.base.MyDrawerActivity;

public class MobiletopupFragment extends Fragment {

    public static MobiletopupFragment newInstance(String param1, String param2) {
        MobiletopupFragment fragment = new MobiletopupFragment();

        return fragment;
    }

    public MobiletopupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView= inflater.inflate(R.layout.fragment_mobiletopup, container, false);

        return convertView;
    }

    @Override
    public void onResume() {
        super.onResume();
//        ((MyDrawerActivity)getActivity()).setToolColor(getResources().getColor(R.color.color_mobiletopup));
    }
}
