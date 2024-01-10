package com.example.gymdolphin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button recoverPasswordButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Set up ActionBar with a custom back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back_ic);
        }

        emailEditText = findViewById(R.id.emailEditText);
        recoverPasswordButton = findViewById(R.id.recoverPasswordButton);
        backButton = findViewById(R.id.backButton);

        recoverPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the entered email
                String email = emailEditText.getText().toString();

                // Check if the email is not empty
                if (!email.isEmpty()) {
                    // Implement your password recovery logic here
                    // For now, display a toast message indicating the recovery process
                    Toast.makeText(ForgotPasswordActivity.this, "Password recovery initiated for " + email, Toast.LENGTH_SHORT).show();
                } else {
                    // Display a toast message if the email is empty
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up click listener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); // Simulate a back button press
            }
        });
    }
}
