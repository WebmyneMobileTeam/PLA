package com.webmyne.paylabas_affiliate.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.gc.materialdesign.widgets.SnackBar;
import com.google.gson.GsonBuilder;
import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.cash_in_out.Cash_IN_OUT_Activity;
import com.webmyne.paylabas_affiliate.cash_in_out.Home_fragment_Cash_IN_OUT;
import com.webmyne.paylabas_affiliate.custom_components.SquareLayout;
import com.webmyne.paylabas_affiliate.giftcode.GiftCodeActivity;
import com.webmyne.paylabas_affiliate.giftcode.GiftCodeFragment;
import com.webmyne.paylabas_affiliate.helpers.AppConstants;
import com.webmyne.paylabas_affiliate.helpers.ComplexPreferences;
import com.webmyne.paylabas_affiliate.mobile_topup.MobileTopupActivity;
import com.webmyne.paylabas_affiliate.mobile_topup.MobiletopupFragment;
import com.webmyne.paylabas_affiliate.model.AffilateUser;


public class HomeFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private LinearLayout linearGiftCode;
    private LinearLayout linearCashInOut;
    private LinearLayout linearMobileTopup;
    private AffilateUser affilateUser;



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
    public void onResume() {
        super.onResume();
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(getActivity(), "user_pref", 0);
        affilateUser = complexPreferences.getObject("current_user",AffilateUser.class);
        getBalanceAndDisplay();
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

                    if(!affilateUser.AllowGC){
                        SnackBar bar = new SnackBar(getActivity(), "You are not authorized to access this");
                        bar.show();
                    } else {
                        Intent i2 = new Intent(getActivity(), GiftCodeActivity.class);
                        startActivity(i2);
                    }



                    break;

                case R.id.linearCashInOut:
                   /* ft.replace(R.id.main_container,new Home_fragment_Cash_IN_OUT(),"CASH_IN_OUT");
                    ft.commit();
                    for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                        fm.popBackStack();
                    }*/

                    if(!affilateUser.AllowCashIN && !affilateUser.AllowCashOut){
                        SnackBar bar = new SnackBar(getActivity(), "You are not authorized to access this");
                        bar.show();
                    } else {
                        Intent i3 = new Intent(getActivity(), Cash_IN_OUT_Activity.class);
                        startActivity(i3);
                    }


                    break;

                case R.id.linearMobileTopup:
                    if(!affilateUser.AllowMobileTopUp){
                        SnackBar bar = new SnackBar(getActivity(), "You are not authorized to access this");
                        bar.show();
                    } else {
                        Intent intent = new Intent(getActivity(), MobileTopupActivity.class);
                        startActivity(intent);
                    }
//                    ft.replace(R.id.main_container,new MobiletopupFragment(),"MOBILE_TOPUP");
//                    ft.commit();
//                    for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
//                        fm.popBackStack();
//                    }

                    break;

            }// end of switch
        }
    };

    private void getBalanceAndDisplay() {

        ((MyDrawerActivity)getActivity()).setToolTitle("Hi, "+affilateUser.FName);
//        ((MyDrawerActivity)getActivity()).showToolLoading();
//
//
//        new CallWebService(AppConstants.USER_DETAILS+user.UserID,CallWebService.TYPE_JSONOBJECT) {
//
//            @Override
//            public void response(String response) {
//
//                Log.e("Response User Details ", response);
//                User currentUser = new GsonBuilder().create().fromJson(response,User.class);
//                ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(getActivity(), "user_pref", 0);
//                complexPreferences.putObject("current_user", currentUser);
//                complexPreferences.commit();
//                user = complexPreferences.getObject("current_user", User.class);
//                try{
//                    ((MyDrawerActivity)getActivity()).setToolSubTitle("Balance "+getResources().getString(R.string.euro)+" "+user.LemonwayAmmount);
//                    ((MyDrawerActivity)getActivity()).hideToolLoading();
//                }catch(Exception e){
//
//                }
//            }
//            @Override
//            public void error(VolleyError error) {
//                try{
//                    ((MyDrawerActivity)getActivity()).hideToolLoading();
//                }catch(Exception e){}
//
//            }
//        }.start();

    }

// end of main class
}
