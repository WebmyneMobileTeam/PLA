package com.webmyne.paylabas_affiliate.giftcode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.cash_in_out.Fragment_Cash_OUT2;
import com.webmyne.paylabas_affiliate.custom_components.CircleDialog;
import com.webmyne.paylabas_affiliate.model.GiftCode;
import com.webmyne.paylabas_affiliate.model.User;


import java.util.ArrayList;

public class RedeemGCFragment_Parent extends Fragment {


    public static RedeemGCFragment_Parent newInstance(String param1, String param2) {
        RedeemGCFragment_Parent fragment = new RedeemGCFragment_Parent();
        return fragment;
    }

    public RedeemGCFragment_Parent() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View convertView = inflater.inflate(R.layout.fragment_redeem_gc, container, false);

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.reedem_container, new RedeemGCFragment1());
        ft.commit();



        return convertView;
    }

    @Override
    public void onResume() {
        super.onResume();

     /*   ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(getActivity(), "user_pref", 0);
        user = complexPreferences.getObject("current_user", User.class);*/
    }

}