package com.webmyne.paylabas_affiliate.giftcode;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.gc.materialdesign.views.ButtonRectangle;
import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.cash_in_out.Verifiy_Cash_out_Fragment;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link com.webmyne.paylabas_affiliate.giftcode.RedeemGCFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedeemGCFragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText edMobileno;
    private EditText edAmount;
    private LinearLayout linear_layout_amount;
    private Spinner spReedemAmount;

    private ButtonRectangle btnNext;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Cash_OUT.
     */
    // TODO: Rename and change types and number of parameters
    public static RedeemGCFragment3 newInstance(String param1, String param2) {
        RedeemGCFragment3 fragment = new RedeemGCFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RedeemGCFragment3() {
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
        View convertview = inflater.inflate(R.layout.fragment_redeemgc3, container, false);
        final LinearLayout linear_layout_amount = (LinearLayout)convertview.findViewById(R.id.linear_layout_amount);
        Spinner spReedemAmount = (Spinner)convertview.findViewById(R.id.spReedemAmount);

       /* ButtonRectangle btnNext = (ButtonRectangle)convertview.findViewById(R.id.btnNext);
        EditText edMobileno= (EditText)convertview.findViewById(R.id.edMobileno);
        EditText edAmount= (EditText)convertview.findViewById(R.id.edAmount);
       */




        spReedemAmount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(position==1){
                        linear_layout_amount.setVisibility(View.VISIBLE);
                    }
                    else  linear_layout_amount.setVisibility(View.GONE);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return convertview;
    }

//end of main class
}
