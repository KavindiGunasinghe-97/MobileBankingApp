package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.uee.cdbinet.sidenav.LoanLeaseFragment;

public class TransferActivity extends AppCompatActivity {


    Button next, done;
    LinearLayout AccountDetailsView, paymentDetailsView;
    TextView step1, step2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        setHeaderView("Pay Saved Bill");


//        initialize();
//        eventHandler();


        AccountDetailsView = findViewById(R.id.step1_layout);
        paymentDetailsView = findViewById(R.id.step2_layout);

        next = findViewById(R.id.btn_debitNext);
        done = findViewById(R.id.btn_transferFinish);

        step1 = findViewById(R.id.lo_beneficiary_layout);
        step2 = findViewById(R.id.lo_payment_layout);

        next.setOnClickListener(new MoveTab());

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newIntent = new Intent(TransferActivity.this,TransferReviewActivity.class);
                startActivity(newIntent);

            }
        });




    }

    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }


//    public void initialize(){
//
//        spinutilityName = (Spinner) findViewById(R.id.sp_debitAccNo);
//        availableBalance = (EditText) findViewById(R.id.et_debitAccName);
//        radio = (RadioGroup) findViewById(R.id.rd_type);
//        spinaccountName = (Spinner) findViewById(R.id.sp_accountName);
//
//        accountName = (EditText) findViewById(R.id.et_availableBalance);
//        prefferedAmount = (EditText) findViewById(R.id.et_prefferedAmt);
//        fee = (EditText) findViewById(R.id.et_fee);
//        totDebtAmount = (EditText) findViewById(R.id.et_totDebtAmt);
//        paymentDate = (TextView) findViewById(R.id.tv_paymentDate);
//        btnpaymentDate = (ImageView) findViewById(R.id.btn_paymentDate);
//        cbAccept = (CheckBox) findViewById(R.id.cb_accept);
//        btnSaveBillsNext = (Button) findViewById(R.id.btn_saveBillsNext);
//
//
//    }


    public class MoveTab implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            String btn = ((TextView) v).getText() + "";


            if(btn.contains("Next"))
            {

                AccountDetailsView.setVisibility(View.GONE);
                paymentDetailsView.setVisibility(View.VISIBLE);

                step2.setBackgroundResource(R.drawable.bottom_line_rounded);
                step1.setBackgroundResource(R.color.colorWhite);



            }


        }
    }



}