package com.example.gymdolphin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button signInButton, notMemberButton;
    private TextView forgotPasswordTextView, continueAsGuestTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        notMemberButton = findViewById(R.id.notMemberButton);
        continueAsGuestTextView = findViewById(R.id.continueAsGuestTextView);
        mAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve email and password from EditText fields
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Validate if email and password are not empty
                if (!email.isEmpty() && !password.isEmpty()) {
                    signIn(email, password);
                } else {
                    showToast("Please enter email and password");
                }
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotPasswordIntent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                startActivity(forgotPasswordIntent);
            }
        });

        notMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        continueAsGuestTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catalogIntent = new Intent(MainActivity.this, CatalogActivity.class);
                startActivity(catalogIntent);
            }
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            showToast("Sign-in successful!");
                            // You can navigate to another activity or perform actions as needed
                        } else {
                            showToast("Sign-in failed. Please check your credentials.");
                        }
                    }
                });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
