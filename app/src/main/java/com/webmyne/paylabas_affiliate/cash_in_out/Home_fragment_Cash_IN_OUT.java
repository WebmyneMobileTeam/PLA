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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_fragment_Cash_IN_OUT#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_fragment_Cash_IN_OUT extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    PagerSlidingTabStrip tabs;
    public ViewPager pager;
    public MyPagerAdapter adapter;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_fragment_Cash_IN_OUT.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_fragment_Cash_IN_OUT newInstance(String param1, String param2) {
        Home_fragment_Cash_IN_OUT fragment = new Home_fragment_Cash_IN_OUT();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Home_fragment_Cash_IN_OUT() {
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
        // Inflate the layout for this fragment
        View convertView =inflater.inflate(R.layout.fragment_home_fragment__cash__in__out, container, false);
        tabs=(PagerSlidingTabStrip)convertView.findViewById(R.id.tabs_cash_in_out);
        pager=(ViewPager)convertView.findViewById(R.id.pager_cash_in_out);


        adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);


        return convertView;
    }
    public class MyPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {"CASH IN","CASH OUT"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return Fragment_Cash_IN.newInstance("", "");
            } else if (position == 1) {
                return Fragment_Cash_OUT.newInstance("", "");
            } else {
                return Home_fragment_Cash_IN_OUT.newInstance("", "");
            }
        }
    }
// end of main class
}
