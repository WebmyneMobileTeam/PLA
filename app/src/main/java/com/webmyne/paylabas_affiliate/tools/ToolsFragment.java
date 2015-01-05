package com.webmyne.paylabas_affiliate.tools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.PagerSlidingTabStrip;

public class ToolsFragment extends Fragment {

    PagerSlidingTabStrip tabs;
    ViewPager pager;
    private MyPagerAdapter adapter;

    public static ToolsFragment newInstance(String param1, String param2) {
        ToolsFragment fragment = new ToolsFragment();

        return fragment;
    }

    public ToolsFragment() {
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
        View convertView = inflater.inflate(R.layout.fragment_tools, container, false);
        tabs = (PagerSlidingTabStrip) convertView.findViewById(R.id.toolTabs);
        pager = (ViewPager) convertView.findViewById(R.id.toolPager);
        return convertView;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tabs.setViewPager(pager);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {


        private final String[] TITLES = {"Combine GC", "Currency Converter"};

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
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return new CombineGCFragment();
            } else  {
                return new CurrencyCoverterFragment();
            }
        }
    }
}
