package com.webmyne.paylabas_affiliate.tools;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonRectangle;
import com.webmyne.paylabas_affiliate.R;

public class CurrencyCoverterFragment extends Fragment {

    private ButtonRectangle btnCheckPrice;
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
        View convertView= inflater.inflate(R.layout.fragment_currency_coverter, container, false);
        btnCheckPrice=(ButtonRectangle)convertView.findViewById(R.id.btnCheckPrice);
        btnCheckPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.entry, R.anim.exit,R.anim.entry, R.anim.exit);
                ft.replace(R.id.currency_covert_main, new CurrencyCovertVerification(), "c_convert_verify");
                ft.addToBackStack("");
                ft.commit();
            }
        });
        return convertView;


    }



}
