package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserProfileActivity extends AppCompatActivity {

    private TextView headerTextView, usernameTextView, firstNameTextView, lastNameTextView,
            birthdayTextView, emailTextView, passwordTextView;
    private ImageView firstNameIcon, lastNameIcon, updateBirthdayIcon, updateEmailIcon, updatePasswordIcon;
    private LinearLayout fieldsLayout;
    private Button saveButton;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Initialize UI components
        initViews();

        // Retrieve username from the intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_EXTRA");

        // Set the username in the TextView
        usernameTextView.setText(username);

        // Fetch user data from Firestore based on the username
        fetchUserData(username);

        // Set click listeners for the icons
        setIconClickListeners();

        // Set Bottom Navigation Bar listener
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set other listeners or perform other operations as needed...
    }

    private void initViews() {
        usernameTextView = findViewById(R.id.usernameTextView);
        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        birthdayTextView = findViewById(R.id.birthdayTextView);
        emailTextView = findViewById(R.id.emailTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        firstNameIcon = findViewById(R.id.firstNameIcon);
        lastNameIcon = findViewById(R.id.lastNameIcon);
        updateBirthdayIcon = findViewById(R.id.updatebirthday);
        updateEmailIcon = findViewById(R.id.updateEmail);
        updatePasswordIcon = findViewById(R.id.updatePassword);
        fieldsLayout = findViewById(R.id.fieldsLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void fetchUserData(String username) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users")
                .document(username)
                .get()
                .addOnCompleteListener(task -> {

                    if (task.isSuccessful() && task.getResult() != null) {
                        DocumentSnapshot document = task.getResult();

                        // Retrieve user data from the document
                        String firstName = document.getString("firstName");
                        String lastName = document.getString("lastName");
                        String birthday = document.getString("birthday");
                        String email = document.getString("email");
                        String password = document.getString("password");

                        // Set the data in the TextViews
                        firstNameTextView.setText(firstName);
                        lastNameTextView.setText(lastName);
                        birthdayTextView.setText(birthday);
                        emailTextView.setText(email);
                        passwordTextView.setText(password);

                        // You can perform other operations with the fetched data if needed...
                    } else {
                        Log.e("UserProfileActivity", "Error getting user data", task.getException());
                        // Handle the error
                    }
                });
    }

    private void setIconClickListeners() {
        firstNameIcon.setOnClickListener(v -> updateFieldInFirebase("firstName", firstNameTextView.getText().toString()));
        lastNameIcon.setOnClickListener(v -> updateFieldInFirebase("lastName", lastNameTextView.getText().toString()));
        updateBirthdayIcon.setOnClickListener(v -> updateFieldInFirebase("birthday", birthdayTextView.getText().toString()));
        updateEmailIcon.setOnClickListener(v -> updateFieldInFirebase("email", emailTextView.getText().toString()));
        updatePasswordIcon.setOnClickListener(v -> updateFieldInFirebase("password", passwordTextView.getText().toString()));
    }

    private void updateFieldInFirebase(String field, String value) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Retrieve username from the intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_EXTRA");

        // Create a map to update the specified field
        Map<String, Object> data = new HashMap<>();
        data.put(field, value);

        // Update the field in the Firestore database
        db.collection("users")
                .document(username)
                .update(data)
                .addOnSuccessListener(aVoid -> {
                    // Field updated successfully
                    Toast.makeText(UserProfileActivity.this, "Field updated successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    // Handle the error
                    Log.e("UserProfileActivity", "Error updating field", e);
                    Toast.makeText(UserProfileActivity.this, "Error updating field", Toast.LENGTH_SHORT).show();
                });
    }

    // Bottom Navigation Bar Listener
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();

                    if (itemId == R.id.nav_user) {
                        // Handle user icon click
                        String username = getIntent().getStringExtra("USERNAME_EXTRA");
                        startActivity(new Intent(UserProfileActivity.this, UserProfileActivity.class)
                                .putExtra("USERNAME_EXTRA", username));
                        finish();
                        return true;
                    } else if (itemId == R.id.nav_cart) {
                        // Handle cart icon click
                        // Example: startActivity(new Intent(UserProfileActivity.this, CartActivity.class));
                        finish();
                        return true;
                    } else if (itemId == R.id.nav_catalog) {
                        // Handle home icon click
                        String username = getIntent().getStringExtra("USERNAME_EXTRA");
                        startActivity(new Intent(UserProfileActivity.this, CatalogActivity.class)
                                .putExtra("USERNAME_EXTRA", username));
                        finish();
                        return true;
                    }

                    return false;
                }
            };
}
