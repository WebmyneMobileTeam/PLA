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


public class Launcher extends ActionBarActivity {

    private TextView btnLoginNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        btnLoginNext= (TextView) findViewById(R.id.btnLoginNext);
        btnLoginNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Launcher.this,VerificationActivity.class);
                startActivity(intent);
            }
        });
    }



}
