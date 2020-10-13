package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;
import com.uee.cdbinet.sidenav.HomeFragment;

public class PaySaveBillsReviewActivity extends AppCompatActivity {

    private String uName, spAccName, balance, accName, preAmount, feeTot, totAmount, date;
    public TextView tvrUtilityName, tvrAccountNo, tvrAvailableBalance, tvrAccountName, tvrPaymentDate;
    public TextView tvrPrefferedAmt, tvrFee, tvrTotDebtAmt;
    public Button btnSaveBillsSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_save_bills_review);

        setHeaderView("Pay Saved Bill Review");

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        uName = extras.getString("uName");
        spAccName = extras.getString("spAccName");
        accName = extras.getString("accName");
        balance = extras.getString("balance");
        preAmount = extras.getString("preAmount");
        feeTot = extras.getString("feeTot");
        totAmount = extras.getString("totAmount");
        date = extras.getString("date");


        initialize();
        displayDetails();

        btnSaveBillsSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StyleableToast.makeText(PaySaveBillsReviewActivity.this, " Payment Completed Successfully", Toast.LENGTH_LONG, R.style.StylableToast).show();
                Intent homeIntent = new Intent(PaySaveBillsReviewActivity.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

    }

    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }




    public void initialize(){

        tvrUtilityName = (TextView) findViewById(R.id.tvr_utilityName);
        tvrAccountNo = (TextView) findViewById(R.id.tvr_accountNo);
        tvrAvailableBalance = (TextView) findViewById(R.id.tvr_availableBalance);
        tvrAccountName = (TextView) findViewById(R.id.tvr_accountName);
        tvrPaymentDate = (TextView) findViewById(R.id.tvr_paymentDate);
        tvrPrefferedAmt = (TextView) findViewById(R.id.tvr_prefferedAmt);
        tvrFee = (TextView) findViewById(R.id.tvr_fee);
        tvrTotDebtAmt = (TextView) findViewById(R.id.tvr_totDebtAmt);
        btnSaveBillsSubmit = (Button) findViewById(R.id.btn_saveBillsSubmit);


    }


    private void displayDetails() {

        try {

            tvrUtilityName.setText(uName);
            tvrAccountNo.setText(spAccName);
            tvrAvailableBalance.setText(balance);
            tvrAccountName.setText(accName);
            tvrPaymentDate.setText(date);
            tvrPrefferedAmt.setText(preAmount);
            tvrFee.setText(feeTot);
            tvrTotDebtAmt.setText(totAmount);

        }catch (Exception e){


        }


    }



}