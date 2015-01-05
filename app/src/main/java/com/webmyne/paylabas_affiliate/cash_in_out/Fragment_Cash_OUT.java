package com.webmyne.paylabas_affiliate.cash_in_out;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gc.materialdesign.views.Button;
import com.gc.materialdesign.views.ButtonRectangle;
import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.base.VerificationActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Cash_OUT#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Cash_OUT extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText edMobileno;
    private EditText edAmount;

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
    public static Fragment_Cash_OUT newInstance(String param1, String param2) {
        Fragment_Cash_OUT fragment = new Fragment_Cash_OUT();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_Cash_OUT() {
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
        View convertview = inflater.inflate(R.layout.fragment_fragment__cash__out, container, false);
        ButtonRectangle btnNext = (ButtonRectangle)convertview.findViewById(R.id.btnNext);
        EditText edMobileno= (EditText)convertview.findViewById(R.id.edMobileno);
        EditText edAmount= (EditText)convertview.findViewById(R.id.edAmount);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verfiyRecipient = new Intent( getActivity() ,VerificationActivity.class );
                startActivity(verfiyRecipient);
                getActivity().finish();
            }
        });

        return convertview;
    }

//end of main class
}
