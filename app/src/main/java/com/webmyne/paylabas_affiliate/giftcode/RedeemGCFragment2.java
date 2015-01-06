package com.webmyne.paylabas_affiliate.giftcode;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webmyne.paylabas_affiliate.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link com.webmyne.paylabas_affiliate.giftcode.RedeemGCFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedeemGCFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView btnBack;
    private TextView btnVerify;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Verifiy_Cash_out_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RedeemGCFragment2 newInstance(String param1, String param2) {
        RedeemGCFragment2 fragment = new RedeemGCFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RedeemGCFragment2() {
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
        View converview =  inflater.inflate(R.layout.fragment_verifiy_cashout, container, false);

        TextView btnVerify = (TextView)converview.findViewById(R.id.btnVerify);
        btnVerify.setBackgroundColor(getActivity().getResources().getColor(R.color.color_giftcode));


        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentManager fm = getActivity().getSupportFragmentManager();
                final FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.entry, R.anim.exit,R.anim.entry, R.anim.exit);
                ft.replace(R.id.reedem_container,new RedeemGCFragment3());
                ft.commit();
                for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                    fm.popBackStack();
                }
            }
        });

        return converview;
    }

// end of main class
}
