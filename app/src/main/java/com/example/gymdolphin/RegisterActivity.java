package com.example.gymdolphin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private EditText birthdayEditText;
    private ProgressBar progressBar;
    private EditText emailEditText;
    private EditText passwordEditText;
    private ImageButton backButton;
    private Button createAccountButton;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        birthdayEditText = findViewById(R.id.birthdayEditText);
        emailEditText = findViewById(R.id.emailEditText);  // Added this line
        passwordEditText = findViewById(R.id.passwordEditText);  // Added this line
        backButton = findViewById(R.id.backButton);
        createAccountButton = findViewById(R.id.createAccountButton);
        progressBar = findViewById(R.id.progressBar);

        birthdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        // Set up click listener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Set up click listener for the create account button
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                // Retrieve email and password from EditText fields
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Validate if email and password are not empty
                if (!email.isEmpty() && !password.isEmpty()) {
                    createAccount(email, password);
                } else {
                    showToast("Please enter email and password");
                }
            }
        });
    }

    private void showDatePicker() {
        final Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int day = currentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                // Update the EditText with the selected date
                birthdayEditText.setText(selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay);
            }
        }, year, month, day);

        datePicker.show();
    }

    private void createAccount(String email, String password) {
        System.out.println(email);
        System.out.println(password);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("RegisterActivity", "createUserWithEmail:success, UID: " + user.getUid());
                            showToast("Success");
                        } else {
                            Log.w("RegisterActivity", "createUserWithEmail:failure", task.getException());
                            showToast("Failed");
                        }
                    }
                });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
