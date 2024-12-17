package com.example.clienttracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize dashboard cards
        CardView clientInfoCard = findViewById(R.id.Client);
        CardView addClientCard = findViewById(R.id.add_data);
        CardView membershipCard = findViewById(R.id.membership_plan);
        CardView profileCard = findViewById(R.id.profile);

        // Set click listeners
        clientInfoCard.setOnClickListener(v -> 
            startActivity(new Intent(DashboardActivity.this, Client.class)));

        addClientCard.setOnClickListener(v -> 
            startActivity(new Intent(DashboardActivity.this, AddDataActivity.class)));

        membershipCard.setOnClickListener(v -> 
            startActivity(new Intent(DashboardActivity.this, MembershipPlanActivity.class)));

        profileCard.setOnClickListener(v -> 
            startActivity(new Intent(DashboardActivity.this, ProfileActivity.class)));
    }
}