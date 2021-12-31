package com.andrewgood.appznov1201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class LogoActivity extends AppCompatActivity {

    private Animation textAnim;
    private TextView logoTextStart, logoTextEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        init();
    }

    private void init() {
        textAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_text_anim);
        logoTextStart = findViewById(R.id.tv_start_logo_zno);
        logoTextEnd = findViewById(R.id.tv_start_logo_wordlist);
        logoTextStart.startAnimation(textAnim);
        logoTextEnd.startAnimation(textAnim);
        startMainActivity();
    }

    private void startMainActivity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent (LogoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}