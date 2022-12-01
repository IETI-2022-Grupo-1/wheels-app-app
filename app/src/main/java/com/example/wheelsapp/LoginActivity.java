package com.example.wheelsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wheelsapp.entities.api_request.LoginRequest;
import com.example.wheelsapp.entities.api_responses.LoginResponse;
import com.example.wheelsapp.services.APIAuthService;
import com.example.wheelsapp.utils.RetrofitHelper;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);
    APIAuthService apiAuthService;

    @Override
    protected void onCreate(Bundle saveInstanceSate) {
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.activity_login);
    }

    public void logIn(View v) {
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress2);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword2);
        
        final LoginActivity loginActivityObject = this;
        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailEditText.setError("Email can't be empty");
        }
        
        if (password.isEmpty()) {
            passwordEditText.setError("Password can't be empty");
        } else {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        apiAuthService = RetrofitHelper.getInstance().create(APIAuthService.class);
                        Response<LoginResponse> response = apiAuthService.login(new LoginRequest(email, password)).execute();
                        LoginResponse token = response.body();
                        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

                        if (token.getToken() == null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(loginActivityObject);
                            builder.setTitle("Error");
                            builder.setMessage("Not valid email or password, please try again");
                            AlertDialog alertDialog = builder.create();

                            alertDialog.show();
                            return;
                        }
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("TOKEN_KEY", "Bearer " + token.getToken());
                        editor.commit();

                        Intent intent = new Intent(loginActivityObject, MainActivity2.class);
                        startActivity(intent);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void register(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
