package com.webmyne.paylabas_affiliate.cash_in_out;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonRectangle;
import com.webmyne.paylabas_affiliate.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Cash_IN#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Cash_IN extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ButtonRectangle btnReset;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Cash_IN.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Cash_IN newInstance(String param1, String param2) {
        Fragment_Cash_IN fragment = new Fragment_Cash_IN();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_Cash_IN() {
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
        View convertview =inflater.inflate(R.layout.fragment__cash__in, container, false);
        btnReset = (ButtonRectangle)convertview.findViewById(R.id.btnReset);
        btnReset.setTextColor(Color.parseColor("#494949"));

        return convertview;
    }


}
