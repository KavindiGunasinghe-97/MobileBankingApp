package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PaySaveBillsActivity extends AppCompatActivity {

    public EditText availableBalance, accountName, prefferedAmount, fee, totDebtAmount;
    public Spinner spinutilityName, spinaccountName;
    public TextView paymentDate;
    public ImageView btnpaymentDate;
    public CheckBox cbAccept;
    public Button btnSaveBillsNext;
    private String uName, spAccName, balance, accName, preAmount, feeTot, totAmount, date;
    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_save_bills);


        setHeaderView("Pay Saved Bill");


        initialize();
        eventHandler();
    }

    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }

    public void initialize(){

        spinutilityName = (Spinner) findViewById(R.id.sp_utilityName);
        spinaccountName = (Spinner) findViewById(R.id.sp_accountName);
        availableBalance = (EditText) findViewById(R.id.et_availableBalance);
        accountName = (EditText) findViewById(R.id.et_accountName);
        prefferedAmount = (EditText) findViewById(R.id.et_prefferedAmt);
        fee = (EditText) findViewById(R.id.et_fee);
        totDebtAmount = (EditText) findViewById(R.id.et_totDebtAmt);
        paymentDate = (TextView) findViewById(R.id.tv_paymentDate);
        btnpaymentDate = (ImageView) findViewById(R.id.btn_paymentDate);
        cbAccept = (CheckBox) findViewById(R.id.cb_accept);
        btnSaveBillsNext = (Button) findViewById(R.id.btn_saveBillsNext);


    }

    public void eventHandler(){


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel();
            }

        };

        btnpaymentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO Auto-generated method stub
                new DatePickerDialog(PaySaveBillsActivity.this, R.style.DialogTheme, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        btnSaveBillsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendEnteredData();


            }
        });


    }

    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        paymentDate.setText(sdf.format(myCalendar.getTime()));
    }

    public void sendEnteredData(){

        uName = spinutilityName.getSelectedItem().toString();
        spAccName = spinaccountName.getSelectedItem().toString();
        balance = availableBalance.getText().toString();
        accName = accountName.getText().toString();
        preAmount = prefferedAmount.getText().toString();
        feeTot = fee.getText().toString();
        totAmount = totDebtAmount.getText().toString();
        date = paymentDate.getText().toString();

        Intent intent = new Intent(this, PaySaveBillsReviewActivity.class);
        Bundle extras = new Bundle();
        extras.putString("uName", uName);
        extras.putString("spAccName", spAccName);
        extras.putString("balance", balance);
        extras.putString("accName", accName);
        extras.putString("preAmount", preAmount);
        extras.putString("feeTot", feeTot);
        extras.putString("totAmount", totAmount);
        extras.putString("date", date);
        intent.putExtras(extras);
        startActivity(intent);


    }



}