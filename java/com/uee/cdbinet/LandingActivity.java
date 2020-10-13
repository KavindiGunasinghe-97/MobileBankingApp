package com.uee.cdbinet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uee.cdbinet.util.Config;

public class LandingActivity extends AppCompatActivity {

    ImageView landingHeader;
    TextView welcomeText;
    Button loginNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        landingHeader = findViewById(R.id.invoice_header);
        welcomeText = findViewById(R.id.tv_welcome);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((int) (Config.getDeviceScreenWidth(LandingActivity.this)), (int) (Config.getDeviceScreenWidth(LandingActivity.this)));
        landingHeader.setLayoutParams(layoutParams);

        loginNav = findViewById(R.id.buttonLoginNav);

        loginNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });



    }
}