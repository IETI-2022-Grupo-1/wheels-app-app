package com.example.wheelsapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wheelsapp.databinding.ActivityMain2Binding;
import com.example.wheelsapp.entities.api_responses.UserResponse;
import com.example.wheelsapp.services.UserService;
import com.example.wheelsapp.utils.RetrofitHelper;

import java.io.IOException;

import retrofit2.Response;

public class PopUpRegisterUser extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_register_user);

        DisplayMetrics sizeWindow = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(sizeWindow);

        int width = sizeWindow.widthPixels;
        int height = sizeWindow.heightPixels;

        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.55));

        editTextName = findViewById(R.id.editTextUserName);
        editTextLastName = findViewById(R.id.editTextUserLastName);
        editTextPhone = findViewById(R.id.editTextUserPhone);
    }

    public void popRegisterUserVal(View v) {
        RegisterActivity.getUser().setName(editTextName.getText().toString().trim());
        RegisterActivity.getUser().setLastName(editTextLastName.getText().toString().trim());
        RegisterActivity.getUser().setPhoneNumber(Integer.parseInt(editTextPhone.getText().toString().trim()));
        if (RegisterActivity.regitserUser() == 201) {
            if (RegisterActivity.getValidateUserOrVhei()) {
                Intent intent = new Intent(PopUpRegisterUser.this, LoginActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(PopUpRegisterUser.this, PopUpRegisterVehic.class);
                startActivity(intent);
            }
        }
    }
}