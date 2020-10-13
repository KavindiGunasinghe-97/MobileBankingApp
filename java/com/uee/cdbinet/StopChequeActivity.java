package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class StopChequeActivity extends AppCompatActivity {

    Button btnChequeStopSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_cheque);

        setHeaderView("Stop Cheque");

        initialize();
        eventHandler();
    }

    public void initialize(){
        btnChequeStopSubmit = (Button) findViewById(R.id.btn_stopChequeSubmit);
    }

    public void eventHandler(){
        btnChequeStopSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleableToast.makeText(StopChequeActivity.this, " Cheque Stop Request sent Successfully", Toast.LENGTH_LONG, R.style.StylableToast).show();
                finish();
            }
        });
    }

    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }
}