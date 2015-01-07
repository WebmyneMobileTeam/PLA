package com.webmyne.paylabas_affiliate.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gc.materialdesign.widgets.SnackBar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.CircleDialog;
import com.webmyne.paylabas_affiliate.helpers.API;
import com.webmyne.paylabas_affiliate.helpers.AppConstants;
import com.webmyne.paylabas_affiliate.helpers.ComplexPreferences;
import com.webmyne.paylabas_affiliate.model.AffilateUser;
import com.webmyne.paylabas_affiliate.model.SendPaymentResponse;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.Reader;


public class Launcher extends ActionBarActivity {

    private TextView btnLoginNext;
    private EditText etMerchantId,etSecretId;
    private CircleDialog circleDialog;
    private AffilateUser affilateUser;
    private boolean isLogin=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // overridePendingTransition(R.anim.entry,R.anim.exit);
        setContentView(R.layout.activity_launcher);
       initView();
    }

    private void initView(){
        etMerchantId= (EditText) findViewById(R.id.etMerchantId);
        etSecretId= (EditText) findViewById(R.id.etSecretId);
        btnLoginNext= (TextView) findViewById(R.id.btnLoginNext);

    }

    @Override
    protected void onResume() {
        super.onResume();
        isLogin=false;
        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        isLogin=preferences.getBoolean("isUserLogin",false);
        if(isLogin==true){
            Intent intent =new Intent(Launcher.this,VerificationActivity.class);
            startActivity(intent);
            finish();
        }
        etMerchantId.setText("4CF5B52A19");
        etSecretId.setText("IY6kn$");
        btnLoginNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMerchantEmpty() || isSecretIdEmpty()){
                    SnackBar bar = new SnackBar(Launcher.this,"Please enter merchant id and secret id");
                    bar.show();
                } else {
                    checkMerchentLogin();
                }

            }
        });
    }

    public boolean isMerchantEmpty(){

        boolean isEmpty = false;

        if(etMerchantId.getText() == null || etMerchantId.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
        }
        return isEmpty;
    }

    public boolean isSecretIdEmpty(){

        boolean isEmpty = false;

        if(etSecretId.getText() == null || etSecretId.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
        }
        return isEmpty;

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.entry,R.anim.exit);
    }


    private void checkMerchentLogin() {

        circleDialog = new CircleDialog(Launcher.this, 0);
        circleDialog.setCancelable(true);
        circleDialog.show();

        JSONObject requestObject = new JSONObject();
        try {
            requestObject.put("MerchantID", etMerchantId.getText().toString().trim() + "");
            requestObject.put("Password", etSecretId.getText().toString().trim() + "");
        } catch (Exception e){
            e.printStackTrace();
        }

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, AppConstants.AFFILATE_LOGIN, requestObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jobj) {
                affilateUser = new GsonBuilder().create().fromJson(jobj.toString(), AffilateUser.class);

                if(affilateUser.ResponseCode.equalsIgnoreCase("1")){
                    //store current user and domain in shared preferences
                    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(Launcher.this, "user_pref", 0);
                    complexPreferences.putObject("current_user", affilateUser);
                    complexPreferences.commit();

                    // set login true

                    SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isUserLogin",true);
                    editor.commit();

                    Intent intent =new Intent(Launcher.this,VerificationActivity.class);
                    startActivity(intent);
                    finish();
                    } else {
                    circleDialog.dismiss();
                    SnackBar bar = new SnackBar(Launcher.this, "Network Error\n" +
                            "Please try again");
                    bar.show();
                    }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                circleDialog.dismiss();

                SnackBar bar = new SnackBar(Launcher.this,"Network Error");
                bar.show();

            }
        });

        req.setRetryPolicy(new DefaultRetryPolicy(0,0,0));

        MyApplication.getInstance().addToRequestQueue(req);

    }

}
