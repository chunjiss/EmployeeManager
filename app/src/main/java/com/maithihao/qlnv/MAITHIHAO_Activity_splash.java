package com.maithihao.qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MAITHIHAO_Activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maithihao_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent = new Intent(MAITHIHAO_Activity_splash.this, MAITHIHAO_Activity.class);
                    startActivity(intent);
                    finish();

            }
        }, 2000);
    }
}