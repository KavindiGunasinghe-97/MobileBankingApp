package com.uee.cdbinet.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.uee.cdbinet.R;

public class Deposit_Calculator extends AppCompatActivity {

    Spinner sp_depositType;
    EditText currency, amount;
    Button rateCal;
    TextView intRate, monthVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit__calculator);
        setHeaderView("Deposit Calculator");

        sp_depositType = (Spinner) findViewById(R.id.sp_depositType);
        currency = (EditText) findViewById(R.id.currency);
        amount = (EditText) findViewById(R.id.amount);
        rateCal = (Button) findViewById(R.id.rateCal);
        intRate = (TextView) findViewById(R.id.intRate);
        monthVal = (TextView) findViewById(R.id.monthVal);

        rateCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int loanAmount = Integer.parseInt(amount.getText().toString());

                String type = sp_depositType.getSelectedItem().toString();


                int iRate = 15;

                int monthlyValue = (iRate * loanAmount) ;



                intRate.setText(String.valueOf(15));
                monthVal.setText(String.valueOf(monthlyValue));


            }
        });
    }
    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }
}