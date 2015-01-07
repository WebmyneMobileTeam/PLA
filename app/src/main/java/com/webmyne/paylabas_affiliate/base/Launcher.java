package com.webmyne.paylabas_affiliate.base;

import android.content.Intent;
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

import com.gc.materialdesign.widgets.SnackBar;
import com.google.gson.GsonBuilder;
import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.CircleDialog;
import com.webmyne.paylabas_affiliate.helpers.API;
import com.webmyne.paylabas_affiliate.helpers.AppConstants;
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
        etMerchantId.setText("4CF5B52A19");
        etSecretId.setText("IY6kn$");

        btnLoginNext= (TextView) findViewById(R.id.btnLoginNext);
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

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                circleDialog = new CircleDialog(Launcher.this, 0);
                circleDialog.setCancelable(true);
                circleDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {

                    JSONObject requestObject = new JSONObject();
                    requestObject.put("MerchantID", etMerchantId.getText().toString().trim() + "");
                    requestObject.put("Password", etSecretId.getText().toString().trim() + "");

                    Reader reader = API.callWebservicePost(AppConstants.AFFILATE_LOGIN, requestObject.toString());

                    affilateUser = new GsonBuilder().create().fromJson(reader, AffilateUser.class);


                    if(affilateUser.ResponseCode.equalsIgnoreCase("1")){
                        handlePostData();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                circleDialog.dismiss();
                                SnackBar bar = new SnackBar(Launcher.this, "Network Error\n" +
                                        "Please try again");
                                bar.show();
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            circleDialog.dismiss();
                            SnackBar bar = new SnackBar(Launcher.this, "Network Error\n" +
                                    "Please try again");
                            bar.show();
                        }
                    });

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                circleDialog.dismiss();
            }
        }.execute();
    }

    private void handlePostData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(Launcher.this,VerificationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
