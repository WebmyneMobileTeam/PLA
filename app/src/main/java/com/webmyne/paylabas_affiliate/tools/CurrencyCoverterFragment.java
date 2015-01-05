package com.webmyne.paylabas_affiliate.tools;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.paylabas_affiliate.R;

public class CurrencyCoverterFragment extends Fragment {

    public static CurrencyCoverterFragment newInstance(String param1, String param2) {
        CurrencyCoverterFragment fragment = new CurrencyCoverterFragment();

        return fragment;
    }

    public CurrencyCoverterFragment() {
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
        return inflater.inflate(R.layout.fragment_currency_coverter, container, false);
    }



}
