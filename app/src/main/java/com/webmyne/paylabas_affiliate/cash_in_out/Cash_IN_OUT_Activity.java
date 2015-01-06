package com.webmyne.paylabas_affiliate.cash_in_out;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.giftcode.GiftCodeFragment;

public class Cash_IN_OUT_Activity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cash__in__out_);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_cashinoutActivity, new Home_fragment_Cash_IN_OUT())
                    .commit();
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  toolbar.setBackgroundColor(getResources().getColor(R.color.));
        if (toolbar != null) {
            toolbar.setTitle("Home");
            setSupportActionBar(toolbar);
        }
        toolbar.setNavigationIcon(R.drawable.ic_action_navigation_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }



}
