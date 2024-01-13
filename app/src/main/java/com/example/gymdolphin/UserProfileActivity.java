package com.example.gymdolphin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserProfileActivity extends AppCompatActivity {

    private TextView usernameTextView, firstNameTextView, lastNameTextView, birthdayTextView, emailTextView, passwordTextView;
    private Button saveButton;
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);

        // Initialize views
        usernameTextView = findViewById(R.id.usernameTextView);
        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        birthdayTextView = findViewById(R.id.birthdayTextView);
        emailTextView = findViewById(R.id.emailTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        // Get the signed-in user's username from the intent extras
        String signedInUsername = getIntent().getStringExtra("USERNAME_EXTRA");

        // Try to retrieve user data from SharedPreferences
        retrieveUserDataFromLocal();

        // If user data is not available locally, fetch it from Firebase
        if (!hasUserDataLocally()) {
            retrieveUserDataFromFirebase(signedInUsername);
        }

        // Handle Bottom Navigation View
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_user) {
                    // Handle user icon click
                    return true;
                } else if (itemId == R.id.nav_cart) {
                    // Handle cart icon click
                    return true;
                } else if (itemId == R.id.nav_catalog) {
                    // Handle home icon click
                    startActivity(new Intent(UserProfileActivity.this, CatalogActivity.class));
                    return true;
                }

                return false;
            }
        });

        // Handle Save Button Click
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Save button clicked!");
                // Add your save logic here
            }
        });
    }

    private void retrieveUserDataFromLocal() {
        String username = sharedPreferences.getString("username", null);
        if (username != null) {
            // Retrieve user data from SharedPreferences and set it to the TextViews
            usernameTextView.setText("Username: " + username);
            firstNameTextView.setText("First Name: " + sharedPreferences.getString("firstName", ""));
            lastNameTextView.setText("Last Name: " + sharedPreferences.getString("lastName", ""));
            birthdayTextView.setText("Birthday: " + sharedPreferences.getString("birthday", ""));
            emailTextView.setText("Email: " + sharedPreferences.getString("email", ""));
            passwordTextView.setText("Password: " + sharedPreferences.getString("password", ""));
        }
    }

    private boolean hasUserDataLocally() {
        // Check if user data is available in SharedPreferences
        return sharedPreferences.contains("username");
    }

    private void retrieveUserDataFromFirebase(String username) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users")
                .whereEqualTo("username", username)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                        // Assuming there is only one document for the provided username
                        DocumentSnapshot document = task.getResult().getDocuments().get(0);

                        // Get user data
                        String firstName = document.getString("firstName");
                        String lastName = document.getString("lastName");
                        String birthday = document.getString("birthday");
                        String email = document.getString("email");
                        String password = document.getString("password");

                        // Set the retrieved data to the corresponding TextViews
                        usernameTextView.setText("Username: " + username);
                        firstNameTextView.setText("First Name: " + firstName);
                        lastNameTextView.setText("Last Name: " + lastName);
                        birthdayTextView.setText("Birthday: " + birthday);
                        emailTextView.setText("Email: " + email);
                        passwordTextView.setText("Password: " + password);

                        // Save user data to SharedPreferences for future use
                        saveUserDataLocally(username, firstName, lastName, birthday, email, password);
                    } else {
                        // Handle the case where user data is not found
                    }
                });
    }

    private void saveUserDataLocally(String username, String firstName, String lastName, String birthday, String email, String password) {
        // Save user data to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("firstName", firstName);
        editor.putString("lastName", lastName);
        editor.putString("birthday", birthday);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
