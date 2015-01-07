package com.webmyne.paylabas_affiliate.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.helpers.ComplexPreferences;
import com.webmyne.paylabas_affiliate.model.AffilateUser;

public class VerificationActivity extends ActionBarActivity {

    private TextView btnFinishSetup;
    private AffilateUser affilateUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // overridePendingTransition(R.anim.entry,R.anim.exit);
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

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences_value = getSharedPreferences("verify", MODE_PRIVATE);


        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(VerificationActivity.this, "user_pref", 0);
        affilateUser = complexPreferences.getObject("current_user",AffilateUser.class);



        SharedPreferences preferences = getSharedPreferences("verify", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isUserVerify",true);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.entry,R.anim.exit);
    }
}
