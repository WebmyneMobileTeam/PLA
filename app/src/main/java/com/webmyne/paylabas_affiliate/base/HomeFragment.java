package com.webmyne.paylabas_affiliate.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.cash_in_out.Home_fragment_Cash_IN_OUT;
import com.webmyne.paylabas_affiliate.custom_components.SquareLayout;
import com.webmyne.paylabas_affiliate.giftcode.GiftCodeActivity;
import com.webmyne.paylabas_affiliate.giftcode.GiftCodeFragment;
import com.webmyne.paylabas_affiliate.mobile_topup.MobileTopupActivity;
import com.webmyne.paylabas_affiliate.mobile_topup.MobiletopupFragment;


public class HomeFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private LinearLayout linearGiftCode;
    private LinearLayout linearCashInOut;
    private LinearLayout linearMobileTopup;




    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View convertView = inflater.inflate(R.layout.fragment_home, container, false);

        linearGiftCode = (LinearLayout)convertView.findViewById(R.id.linearGiftCode);
        linearGiftCode.setOnClickListener(clickListner);
        linearCashInOut = (LinearLayout)convertView.findViewById(R.id.linearCashInOut);
        linearCashInOut.setOnClickListener(clickListner);
        linearMobileTopup = (LinearLayout)convertView.findViewById(R.id.linearMobileTopup);
        linearMobileTopup.setOnClickListener(clickListner);

        return convertView;
    }

    public View.OnClickListener clickListner = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            final FragmentManager fm = getActivity().getSupportFragmentManager();
            final FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.anim.entry, R.anim.exit,R.anim.entry, R.anim.exit);

            switch (v.getId()){
                case R.id.linearGiftCode:

                 /*   ft.replace(R.id.main_container,new GiftCodeFragment(),"GHome");
                    //  ft.addToBackStack("");
                    ft.commit();
                    for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                        fm.popBackStack();
                    }*/

                    Intent i2 = new Intent(getActivity(), GiftCodeActivity.class);
                    startActivity(i2);


                    break;

                case R.id.linearCashInOut:
                    ft.replace(R.id.main_container,new Home_fragment_Cash_IN_OUT(),"CASH_IN_OUT");
                    ft.commit();
                    for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                        fm.popBackStack();
                    }
                    break;

                case R.id.linearMobileTopup:

                    Intent intent=new Intent(getActivity(), MobileTopupActivity.class);
                    startActivity(intent);




//                    ft.replace(R.id.main_container,new MobiletopupFragment(),"MOBILE_TOPUP");
//                    ft.commit();
//                    for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
//                        fm.popBackStack();
//                    }

                    break;

            }// end of switch
        }
    };

// end of main class
}
