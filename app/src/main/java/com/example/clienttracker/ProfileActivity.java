package com.example.clienttracker;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    
    private CircleImageView profilePicture;
    private TextView profileName;
    private TextView membershipType;
    private TextView planDuration;
    private TextView lastVisit;
    private TextView profileEmail;
    private TextView profilePhone;
    private TextView profileAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        initializeViews();
        loadProfileData();
    }

    private void initializeViews() {
        // Initialize all view components
        profilePicture = findViewById(R.id.profile_picture);
        profileName = findViewById(R.id.profile_name);
        membershipType = findViewById(R.id.membership_type);
        planDuration = findViewById(R.id.plan_duration);
        lastVisit = findViewById(R.id.last_visit);
        profileEmail = findViewById(R.id.profile_email);
        profilePhone = findViewById(R.id.profile_phone);
        profileAddress = findViewById(R.id.profile_address);
    }

    private void loadProfileData() {
        // TODO: Load actual user data from your database
        // For now, we'll set sample data
        
        // Set profile picture (you might want to use Glide or Picasso for image loading)
        profilePicture.setImageResource(R.drawable.sample_profile);
        
        // Set text fields with user information
        profileName.setText("John Doe");
        membershipType.setText("Membership: Premium");
        planDuration.setText("Plan: 6 Months");
        lastVisit.setText("Last Visit: " + getCurrentDate());
        profileEmail.setText("Email: john.doe@example.com");
        profilePhone.setText("Phone: +1 123-456-7890");
        profileAddress.setText("Address: 123 Main St, Springfield");
    }

    private String getCurrentDate() {
        // Get current date in the format you want
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy", java.util.Locale.getDefault());
        return sdf.format(new java.util.Date());
    }

    // Method to update profile data (can be called when user edits their profile)
    public void updateProfileData(String name, String email, String phone, String address) {
        profileName.setText(name);
        profileEmail.setText("Email: " + email);
        profilePhone.setText("Phone: " + phone);
        profileAddress.setText("Address: " + address);
        
        // TODO: Save updated data to your database
    }

    // Method to update membership information
    public void updateMembershipInfo(String type, String duration, String lastVisitDate) {
        membershipType.setText("Membership: " + type);
        planDuration.setText("Plan: " + duration);
        lastVisit.setText("Last Visit: " + lastVisitDate);
        
        // TODO: Save updated membership data to your database
    }

    // Method to update profile picture
    public void updateProfilePicture(android.net.Uri imageUri) {
        try {
            android.graphics.Bitmap bitmap = android.provider.MediaStore.Images.Media.getBitmap(
                getContentResolver(), 
                imageUri
            );
            profilePicture.setImageBitmap(bitmap);
            
            // TODO: Save updated profile picture to your storage
        } catch (Exception e) {
            e.printStackTrace();
            android.widget.Toast.makeText(this, 
                "Failed to update profile picture", 
                android.widget.Toast.LENGTH_SHORT).show();
        }
    }
} 