package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserProfileActivity extends AppCompatActivity {

    private TextView usernameTextView, firstNameTextView, lastNameTextView,
            birthdayTextView, emailTextView, passwordTextView;
    private ImageView firstNameIcon, lastNameIcon, updateBirthdayIcon, updateEmailIcon, updatePasswordIcon;
    private LinearLayout fieldsLayout;
    private Button signOutButton;
    private BottomNavigationView bottomNavigationView;

    private EditText firstNameEditText , lastNameEditText, birthdayEditText, emailEditText, passwordEditText;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        initViews();

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_EXTRA");

        usernameTextView.setText(username);

        fetchUserData(username);

        firebaseAuth = FirebaseAuth.getInstance();
        setIconClickListeners();

        signOutButton.setOnClickListener(v -> signOutUser());
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set other listeners or perform other operations as needed...
    }

    private void signOutUser() {
        firebaseAuth.signOut();

        startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
        finish();
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
        signOutButton = findViewById(R.id.signOutButton);
        updateEmailIcon = findViewById(R.id.updateEmail);
        updatePasswordIcon = findViewById(R.id.updatePassword);
        fieldsLayout = findViewById(R.id.fieldsLayout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        birthdayEditText = findViewById(R.id.birthdayEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

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

                    }
                });
    }

    private void setIconClickListeners() {
        firstNameIcon.setOnClickListener(v -> {
            String firstName = firstNameEditText.getText().toString();
            updateFieldInFirebase("firstName", firstName);
        });

        lastNameIcon.setOnClickListener(v -> {
            String lastName = lastNameEditText.getText().toString();
            updateFieldInFirebase("lastName", lastName);
        });

        updateBirthdayIcon.setOnClickListener(v -> {
            String birthday = birthdayEditText.getText().toString();
            updateFieldInFirebase("birthday", birthday);
        });

        updateEmailIcon.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            updateFieldInFirebase("email", email);
        });

        updatePasswordIcon.setOnClickListener(v -> {
            String password = passwordEditText.getText().toString();
            updateFieldInFirebase("password", password);
        });
    }


    private void updateFieldInFirebase(String field, String value) {
        Log.d("UserProfileActivity", "Updating field: " + field + " with value: " + value);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME_EXTRA");

        Map<String, Object> data = new HashMap<>();
        data.put(field, value);

        db.collection("users")
                .document(username)
                .update(data)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(UserProfileActivity.this, "Field updated successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    // Handle the error
                    Log.e("UserProfileActivity", "Error updating field", e);
                    Toast.makeText(UserProfileActivity.this, "Error updating field", Toast.LENGTH_SHORT).show();
                });
    }

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
                        String username = getIntent().getStringExtra("USERNAME_EXTRA");
                        startActivity(new Intent(UserProfileActivity.this, CartActivity.class)
                                .putExtra("USERNAME_EXTRA", username));
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
