package com.example.gymdolphin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button signInButton, notMemberButton;
    private TextView forgotPasswordTextView, continueAsGuestTextView;

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

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement your sign-in logic here
            }
        });

        // Add onClickListener for "forgot password?" link, "Not a member yet?" button, and "continue as a guest" text as needed.
    }
}
