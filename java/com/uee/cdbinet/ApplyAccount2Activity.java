package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class ApplyAccount2Activity extends AppCompatActivity {

    Button applyAccountSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_account_2);

        setHeaderView("Apply for New Account");

        initialize();
        eventHandler();
    }

    public void initialize(){
        applyAccountSubmitButton = (Button) findViewById(R.id.btn_applyAccountSubmit);
    }

    public void eventHandler(){
        applyAccountSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleableToast.makeText(ApplyAccount2Activity.this, " Applied for New Account Successfully", Toast.LENGTH_LONG, R.style.StylableToast).show();
                finish();
            }
        });
    }

    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }
}