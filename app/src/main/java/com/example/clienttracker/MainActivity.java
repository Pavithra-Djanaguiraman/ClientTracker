package com.example.clienttracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //Find Views for Buttons
        CardView btnSignUpGoogle = findViewById(R.id.btn_sign_up_google);
        CardView btnSignUpNumber = findViewById(R.id.btn_sign_up_number);


        TextView loginTextView = findViewById(R.id.tv_login);

        // Set onClickListener for Google Sign-Up Button
        btnSignUpGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Google Sign-Up button clicked");
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });


        // Set onClickListener for Number Sign-Up Button
        btnSignUpNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Number Sign-In page
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        // Set ClickableSpan for "Login" hyperlink
        String text = "Already have an account? Login";
        SpannableString spannableString = new SpannableString(text);

        // Find the start and end index of the "Login" word
        int startIndex = text.indexOf("Login");
        int endIndex = startIndex + "Login".length();

        // Create a ClickableSpan for "Login"
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                // Navigate to Login page
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE); // Set hyperlink color
                ds.setUnderlineText(true); // Add underline to the text
            }
        };

         //Apply the ClickableSpan to the "Login" word
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginTextView.setText(spannableString);
        loginTextView.setMovementMethod(LinkMovementMethod.getInstance());


    }
}
