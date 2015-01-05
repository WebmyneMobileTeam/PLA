package com.webmyne.paylabas_affiliate.base;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.webmyne.paylabas_affiliate.R;

public class VerificationActivity extends ActionBarActivity {

    private TextView btnFinishSetup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        btnFinishSetup= (TextView) findViewById(R.id.btnFinishSetup);
        btnFinishSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(VerificationActivity.this,MyDrawerActivity.class);
                startActivity(intent);
            }
        });

    }


}
