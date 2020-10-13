package com.uee.cdbinet.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.uee.cdbinet.R;

public class Loan_Calculator extends AppCompatActivity {

    Spinner loanType;
    EditText loanCurrency, amount;
    Button loanCal;
    TextView iPaymentResult, iRateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan__calculator);

        loanType = (Spinner) findViewById(R.id.sp_loanType);
        loanCurrency = (EditText) findViewById(R.id.loanCurrency);
        amount = (EditText) findViewById(R.id.amount);
        loanCal = (Button) findViewById(R.id.loanCal);
        iPaymentResult = (TextView) findViewById(R.id.rateResult);
        iRateResult = (TextView) findViewById(R.id.paymentResult);


        loanCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int loanAmount = Integer.parseInt(amount.getText().toString());
                
                String type = loanType.getSelectedItem().toString();


                   int iRate = 10;

                    int monthlyPayment = (iRate * loanAmount) ;



                    iRateResult.setText(String.valueOf(10));
                    iPaymentResult.setText(String.valueOf(monthlyPayment));


            }
        });

    }
    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }
}