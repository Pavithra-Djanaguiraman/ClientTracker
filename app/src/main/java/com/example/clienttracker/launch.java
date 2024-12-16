package com.example.clienttracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        // Find the ImageView for the logo
        ImageView logoIcon = findViewById(R.id.logo_icon);

        // Load the fade-in animation
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Start the animation on the ImageView
        logoIcon.startAnimation(fadeInAnimation);

        // Transition to MainActivity after 3 seconds (fade-in duration)
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the MainActivity
                Intent intent = new Intent(launch.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the LaunchActivity
            }
        }, 3000); // 3-second delay
    }
}
