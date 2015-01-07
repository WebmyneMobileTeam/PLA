package com.webmyne.paylabas_affiliate.cash_in_out;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.PagerSlidingTabStrip;
import com.webmyne.paylabas_affiliate.helpers.ComplexPreferences;
import com.webmyne.paylabas_affiliate.model.AffilateUser;

import java.util.ArrayList;


public class Home_fragment_Cash_IN_OUT extends Fragment {


    PagerSlidingTabStrip tabs;
    public ViewPager pager;
    public MyPagerAdapter adapter;
    private AffilateUser affilateUser;
    private ArrayList<String> TITLES;
    public static Home_fragment_Cash_IN_OUT newInstance(String param1, String param2) {
        Home_fragment_Cash_IN_OUT fragment = new Home_fragment_Cash_IN_OUT();
        return fragment;
    }

    public Home_fragment_Cash_IN_OUT() {
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

        View convertView =inflater.inflate(R.layout.fragment_home_fragment__cash__in__out, container, false);
        tabs=(PagerSlidingTabStrip)convertView.findViewById(R.id.tabs_cash_in_out);
        pager=(ViewPager)convertView.findViewById(R.id.pager_cash_in_out);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        return convertView;
    }

    @Override
    public void onResume() {
        super.onResume();
        TITLES=new ArrayList<String>();
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(getActivity(), "user_pref", 0);
        affilateUser = complexPreferences.getObject("current_user",AffilateUser.class);

        if(!affilateUser.AllowCashIN && affilateUser.AllowCashOut){
            TITLES.add("CASH OUT");
        } else if(affilateUser.AllowCashIN && !affilateUser.AllowCashOut){
            TITLES.add("CASH IN");
        } else  {
            TITLES.add("CASH IN");
            TITLES.add("CASH OUT");
        }
        adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {




        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES.get(position);
        }

        @Override
        public int getCount() {
            return TITLES.size();
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return Fragment_Cash_IN.newInstance("", "");
            } else if (position == 1) {
                return Fragment_Cash_OUT_HOME.newInstance("", "");
            } else {
                return Home_fragment_Cash_IN_OUT.newInstance("", "");
            }
        }
    }
// end of main class
}
