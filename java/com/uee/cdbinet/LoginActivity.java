package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;
import com.uee.cdbinet.util.Config;

public class LoginActivity extends AppCompatActivity {

    public EditText userName, password;
    public TextView forgotPass;
    public Button btnSubmit;
    public String uname, accpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setHeaderView("SIGN IN");

//        initialize();
//        eventHandler();
        LoginButton();

    }

    public void LoginButton() {
        userName = (EditText) findViewById(R.id.et_userName);
        password = (EditText) findViewById(R.id.et_Password);
        btnSubmit = (Button) findViewById(R.id.signin);
        forgotPass = (TextView) findViewById(R.id.forgotPw);

        forgotPass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (userName.getText().toString().equals("user") && password.getText().toString().equals("pass")) {

                            Config.USER_NAME = userName.getText().toString();

                            SharedPreferences sp = getSharedPreferences(Config.LOGIN_TAGS,MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString(Config.LOGIN_USER, Config.USER_NAME);
                            edit.apply();

                            StyleableToast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_LONG, R.style.StylableToast).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {

                            StyleableToast.makeText(LoginActivity.this, "Username or Password incorrect", Toast.LENGTH_LONG, R.style.StylableToast).show();

                        }
                    }
                }
        );
    }

    public void setHeaderView(String title) {

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }

    public void initialize() {
        userName = (EditText) findViewById(R.id.et_userName);
        password = (EditText) findViewById(R.id.et_Password);
        btnSubmit = (Button) findViewById(R.id.signin);
    }

    public void eventHandler() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendEnteredData();
            }
        });
    }

    public void sendEnteredData() {

        uname = userName.getText().toString();
        accpassword = password.getText().toString();

        //Intent intent = new Intent(this, AccStatementFragment.class);
        Bundle extras = new Bundle();
        extras.putString("uname", uname);
        extras.putString("accpassword", accpassword);
        // intent.putExtras(extras);
        //startActivity(intent);
    }

}