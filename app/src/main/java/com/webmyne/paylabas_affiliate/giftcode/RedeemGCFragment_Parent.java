package com.webmyne.paylabas_affiliate.giftcode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.CircleDialog;
import com.webmyne.paylabas_affiliate.model.GiftCode;
import com.webmyne.paylabas_affiliate.model.User;


import java.util.ArrayList;

public class RedeemGCFragment_Parent extends Fragment {

    private ListView listRedeemGC;
    private ArrayList<GiftCode> giftCodes;
    private ArrayList<GiftCode> redeemGiftCodesList;
    private CircleDialog circleDialog;
    private User user;

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
        listRedeemGC = (ListView) convertView.findViewById(R.id.listRedemGC);
        listRedeemGC.setEmptyView(convertView.findViewById(R.id.redeemEmptyView));

        return convertView;
    }

    @Override
    public void onResume() {
        super.onResume();

     /*   ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(getActivity(), "user_pref", 0);
        user = complexPreferences.getObject("current_user", User.class);*/
    }

    private void fillUpRedeemGCs(ArrayList<GiftCode> giftCodes) {

        redeemGiftCodesList = new ArrayList<GiftCode>();

       // G => G.GCFor == Userid && G.isUsed == true && G.CombineGCId == null
        for (GiftCode giftCode : giftCodes) {
           // if (giftCode.isUsed == true) {
               if (giftCode.isUsed == false && giftCode.GCFor == user.UserID && giftCode.CombineGCId < 0 ) {
                redeemGiftCodesList.add(giftCode);
            }
        }

    }





}