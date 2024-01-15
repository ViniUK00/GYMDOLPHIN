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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button signInButton, notMemberButton;
    private TextView forgotPasswordTextView, continueAsGuestTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.emailEditText); // Assuming username is entered in the email field
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);
        notMemberButton = findViewById(R.id.notMemberButton);
        continueAsGuestTextView = findViewById(R.id.continueAsGuestTextView);
        mAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve username and password from EditText fields
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Validate if username and password are not empty
                if (!username.isEmpty() && !password.isEmpty()) {
                    signInWithUsername(username, password);
                } else {
                    showToast("Please enter username and password");
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

    private void signInWithUsername(String username, String password) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users")
                .whereEqualTo("username", username)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful() && task.getResult() != null && !task.getResult().isEmpty()) {
                            // Get the email associated with the provided username
                            String email = task.getResult().getDocuments().get(0).getString("email");

                            // Sign in with the retrieved email and the provided password
                            mAuth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                showToast("Sign-in successful!");
                                                launchCatalogActivity(username);
                                            } else {
                                                showToast("Sign-in failed. Please check your credentials.");
                                            }
                                        }
                                    });
                        } else {
                            showToast("Username not found.");
                        }
                    }
                });
    }


    private void launchCatalogActivity(String username) {
        Intent catalogIntent = new Intent(MainActivity.this, CatalogActivity.class);
        catalogIntent.putExtra("USERNAME_EXTRA", username);
        startActivity(catalogIntent);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
