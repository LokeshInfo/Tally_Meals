package com.tally_meals.ics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Security_Code_activity extends AppCompatActivity
{
    Button submit;
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.security_code);
        submit = (Button) findViewById(R.id.buttn_submit);

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);
        ed6 = (EditText) findViewById(R.id.ed6);
        ed7 = (EditText) findViewById(R.id.ed7);
        ed8 = (EditText) findViewById(R.id.ed8);
        ed9 = (EditText) findViewById(R.id.ed9);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Security_Code_activity.this,Security_password_activity.class);
                startActivity(in);
            }
        });

        Click_Listeners();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    private void Click_Listeners()
    {
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed1.getText().toString().length()==1)
                {   ed2.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed2.getText().toString().length()==1)
                {   ed3.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed3.getText().toString().length()==1)
                {   ed4.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed4.getText().toString().length()==1)
                {   ed5.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed5.getText().toString().length()==1)
                {   ed6.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed6.getText().toString().length()==1)
                {   ed7.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed7.getText().toString().length()==1)
                {   ed8.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ed8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed8.getText().toString().length()==1)
                {   ed9.requestFocus();         }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));    }
}
