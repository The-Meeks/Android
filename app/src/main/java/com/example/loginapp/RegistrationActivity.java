package com.example.loginapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class RegistrationActivity extends AppCompatActivity {

    private EditText usernameInput, emailInput, passwordInput, confirmPasswordInput;
    private Button registerButton;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration); // Link to your registration layout

        // Initialize UI elements
        usernameInput = findViewById(R.id.username_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        confirmPasswordInput = findViewById(R.id.confirm_password_input);
        registerButton = findViewById(R.id.register_button);
        loginRedirectText = findViewById(R.id.login_redirect_text);

        // Handle registration button click
        registerButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (password.equals(confirmPassword)) {
                // Registration logic (e.g., send data to server)
                Toast.makeText(RegistrationActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                // Optionally navigate to another activity after successful registration
                // Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                // startActivity(intent);
            } else {
                Toast.makeText(RegistrationActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle login redirection
        loginRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(intent); // Navigate to Login screen
        });
    }
}
