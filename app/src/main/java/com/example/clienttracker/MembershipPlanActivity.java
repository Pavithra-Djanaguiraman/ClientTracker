package com.example.clienttracker;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.tabs.TabLayout;

public class MembershipPlanActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    
    // Price TextViews
    private TextView platinumPrice;
    private TextView goldPrice;
    private TextView silverPrice;
    
    // Description TextViews
    private TextView platinumDesc;
    private TextView goldDesc;
    private TextView silverDesc;
    
    // Plan CardViews
    private CardView platinumCard;
    private CardView goldCard;
    private CardView silverCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership_plan);

        initializeViews();
        setupTabLayout();
        setupClickListeners();
    }

    private void initializeViews() {
        // Initialize TabLayout
        tabLayout = findViewById(R.id.tabLayout);
        
        // Initialize price TextViews
        platinumPrice = findViewById(R.id.price_platinum);
        goldPrice = findViewById(R.id.price_gold);
        silverPrice = findViewById(R.id.price_silver);
        
        // Initialize description TextViews
        platinumDesc = findViewById(R.id.desc_platinum);
        goldDesc = findViewById(R.id.desc_gold);
        silverDesc = findViewById(R.id.desc_silver);

        // Add tabs
        tabLayout.addTab(tabLayout.newTab().setText("Monthly"));
        tabLayout.addTab(tabLayout.newTab().setText("Yearly"));
    }

    private void setupTabLayout() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updatePrices(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setupClickListeners() {
        // Find all plan layouts
        RelativeLayout platinumLayout = findViewById(R.id.platinum);
        RelativeLayout goldLayout = findViewById(R.id.gold);
        RelativeLayout silverLayout = findViewById(R.id.silver);

        // Set click listeners for each plan
        if (platinumLayout != null) {
            platinumLayout.setOnClickListener(v -> handlePlanSelection("PLATINUM", platinumDesc.getText().toString()));
        }
        if (goldLayout != null) {
            goldLayout.setOnClickListener(v -> handlePlanSelection("GOLD", goldDesc.getText().toString()));
        }
        if (silverLayout != null) {
            silverLayout.setOnClickListener(v -> handlePlanSelection("SILVER", silverDesc.getText().toString()));
        }
    }

    private void updatePrices(int tabPosition) {
        if (tabPosition == 0) { // Monthly prices
            platinumPrice.setText("Price: Rs. 2000");
            goldPrice.setText("Price: Rs. 1800");
            silverPrice.setText("Price: Rs. 1500");
        } else { // Yearly prices (with discount)
            // Calculate yearly prices (10% discount)
            platinumPrice.setText("Price: Rs. 21600"); // 2000 * 12 * 0.9
            goldPrice.setText("Price: Rs. 19440");     // 1800 * 12 * 0.9
            silverPrice.setText("Price: Rs. 16200");    // 1500 * 12 * 0.9
        }
    }

    private void handlePlanSelection(String planType, String features) {
        boolean isYearlyPlan = tabLayout.getSelectedTabPosition() == 1;
        String duration = isYearlyPlan ? "Yearly" : "Monthly";
        String price = getPriceForPlan(planType, isYearlyPlan);
        
        showPlanConfirmationDialog(planType, duration, price, features);
    }

    private String getPriceForPlan(String planType, boolean isYearly) {
        int monthlyPrice;
        switch (planType) {
            case "PLATINUM":
                monthlyPrice = 2000;
                break;
            case "GOLD":
                monthlyPrice = 1800;
                break;
            case "SILVER":
                monthlyPrice = 1500;
                break;
            default:
                return "N/A";
        }
        
        if (isYearly) {
            return "Rs. " + (monthlyPrice * 12 * 0.9); // 10% discount for yearly
        } else {
            return "Rs. " + monthlyPrice;
        }
    }

    private void showPlanConfirmationDialog(String planType, String duration, String price, String features) {
        String message = String.format("Plan: %s\nDuration: %s\nPrice: %s\n\nFeatures:\n%s", 
            planType, duration, price, features);

        new androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Confirm Membership Plan")
            .setMessage(message)
            .setPositiveButton("Confirm", (dialog, which) -> {
                processPlanSelection(planType, duration, price);
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void processPlanSelection(String planType, String duration, String price) {
        // Here you would typically:
        // 1. Save the selected plan to user's profile
        // 2. Process payment
        // 3. Update membership status
        // 4. Navigate to payment screen or confirmation page
        
        // For now, just show a confirmation toast
        String confirmationMessage = String.format("Selected %s plan (%s) for %s", 
            planType, duration, price);
        android.widget.Toast.makeText(this, confirmationMessage, 
            android.widget.Toast.LENGTH_LONG).show();
            
        // Optional: Navigate back to profile or dashboard
        // finish();
    }
} 