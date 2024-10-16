package com.akshat.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    // Here I have declare SPLASH_TIMER
    public static int SPLASH_TIMER = 2000;// This 2000ms = 2sec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);


        // When timer is complete It intent to AddPlayer Activity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, AddPlayers.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER); // Call the timer.
    }
}