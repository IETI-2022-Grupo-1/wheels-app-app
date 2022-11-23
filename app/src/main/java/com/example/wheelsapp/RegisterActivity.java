package com.example.wheelsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceSate) {
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.activity_register);
    }

    public void registerUser(View v) {
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText passwordEditText = findViewById(R.id.editTextPassword);
        Spinner spinner = findViewById(R.id.spinner);
        String[] option = {"Escuela Colombiana de Ingenieria"};

        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, option);

    }
}
