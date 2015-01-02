package com.webmyne.paylabas_affiliate.user_navigation;


import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;

import com.webmyne.paylabas_affiliate.R;
import com.webmyne.paylabas_affiliate.custom_components.PreferenceFragment;


public class FragPref extends PreferenceFragment {

    EditTextPreference edEmail;
    EditTextPreference edMobile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);





        edEmail = (EditTextPreference)findPreference("ed_pref_email");
        edEmail.setText("");
        edEmail.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                edEmail.setTitle(newValue.toString());
                return false;
            }
        });







    }

}
