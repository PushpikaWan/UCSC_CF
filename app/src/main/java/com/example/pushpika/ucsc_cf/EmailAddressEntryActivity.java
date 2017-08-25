package com.example.pushpika.ucsc_cf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class EmailAddressEntryActivity extends AppCompatActivity {
    public static String EmailAddress;
    public String tempEmailAddress;
    EditText email_entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_email_address_entry);
        email_entry = (EditText) findViewById(R.id.Email_address);
    }

    public void sendEmailAddress(View view){
        View focusView = null;
        tempEmailAddress = email_entry.getText().toString();
        // Check for a valid email address.
        if (TextUtils.isEmpty(tempEmailAddress)) {
            email_entry.setError(getString(R.string.error_field_required));
            focusView = email_entry;
            focusView.requestFocus();
        } else if (!isEmailValid(tempEmailAddress)) {
            email_entry.setError(getString(R.string.error_invalid_email));
            focusView = email_entry;
            focusView.requestFocus();
        }
        else{
            EmailAddressEntryActivity.EmailAddress = tempEmailAddress;

            SharedPreferences settings1 = getSharedPreferences("prefs", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putString("Email_Address",tempEmailAddress);
            editor.putBoolean("firstRun", false);
            editor.commit();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}
