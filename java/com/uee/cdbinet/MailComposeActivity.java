package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class MailComposeActivity extends AppCompatActivity {

    Button btnComoseSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_compose);

        setHeaderView("Compose");

        initialize();
        eventHandler();
    }

    public void initialize(){
        btnComoseSubmit = (Button) findViewById(R.id.btn_composeSubmit);
    }

    public void eventHandler(){
        btnComoseSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleableToast.makeText(MailComposeActivity.this, " Mail sent Successfully", Toast.LENGTH_LONG, R.style.StylableToast).show();
                finish();
            }
        });
    }

    public void setHeaderView(String title){

        TextView headerTitle = (TextView) findViewById(R.id.tv_actionbarTitle);
        headerTitle.setText(title);

    }
}