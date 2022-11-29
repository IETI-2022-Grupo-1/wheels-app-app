package com.example.wheelsapp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.IOException;

import android.os.Bundle;
import android.view.View;
import android.os.StrictMode;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wheelsapp.services.UserService;
import com.example.wheelsapp.services.VehiService;
import com.example.wheelsapp.utils.RetrofitHelper;
import com.example.wheelsapp.services.APIAuthService;
import com.example.wheelsapp.databinding.ActivityMain2Binding;
import com.example.wheelsapp.entities.api_request.LoginRequest;
import com.example.wheelsapp.entities.api_request.UserRequest;
import com.example.wheelsapp.entities.api_request.VehiRequest;
import com.example.wheelsapp.entities.api_responses.LoginResponse;
import com.example.wheelsapp.entities.api_responses.UserResponse;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Spinner spinner;
    private static boolean validateUserOrVhei;
    private static UserRequest user;
    private static VehiRequest vehi;
    private static UserResponse userResponse;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceSate) {
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.activity_register);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        user = new UserRequest();
        vehi = new VehiRequest();

        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);

        spinner = findViewById(R.id.spinner);
        validateUserOrVhei = true;
        String[] option = {"Escuela Colombiana de Ingenieria Julio Garavito"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, option);
        spinner.setAdapter(adapter);
    }

    public void popRegisterUser(View v) {
        user.setEmail(emailEditText.getText().toString().trim());
        user.setPassword(passwordEditText.getText().toString().trim());
        user.setOrganization("631feea0ae8ca16cd15a5b12");
        user.setCity("CITY TDB");
        user.setProfilePhoto("PHOTO TBD");

        validateUserOrVhei = true;
        Intent intent = new Intent(RegisterActivity.this, PopUpRegisterUser.class);
        startActivity(intent);
    }

    public void popRegisterVehic(View v) {
        user.setEmail(emailEditText.getText().toString().trim());
        user.setPassword(passwordEditText.getText().toString().trim());
        user.setOrganization("631feea0ae8ca16cd15a5b12");
        user.setCity("CITY TDB");
        user.setProfilePhoto("PHOTO TBD");

        validateUserOrVhei = false;
        Intent intent = new Intent(RegisterActivity.this, PopUpRegisterUser.class);
        startActivity(intent);
    }

    public void login(View v) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public static Integer regitserUser() {
        try {
            UserService userService = RetrofitHelper.getInstance().create(UserService.class);
            Response<UserResponse> response = userService.createUser(RegisterActivity.getUser()).execute();
            userResponse = response.body();

            return response.code();
        } catch (Exception e) {
            e.printStackTrace();
            return 404;
        }
    }

    public static Integer regitserVehi() {
        try {
            APIAuthService apiAuthService = RetrofitHelper.getInstance().create(APIAuthService.class);
            Response<LoginResponse> response = apiAuthService.login(new LoginRequest(user.getEmail(), user.getPassword())).execute();
            LoginResponse token = response.body();

            VehiService vehiService = RetrofitHelper.getInstance().create(VehiService.class);
            Response<VehiRequest> responseVehi = vehiService.createVehi(RegisterActivity.getVehi(), ("Bearer "+token.getToken())).execute();

            return responseVehi.code();
        } catch (Exception e) {
            e.printStackTrace();
            return 404;
        }
    }

    public static boolean getValidateUserOrVhei() {
        return validateUserOrVhei;
    }

    public static UserRequest getUser() {
        return user;
    }

    public static UserResponse getUserResponse() {
        return userResponse;
    }

    public static VehiRequest getVehi() {
        return vehi;
    }
}
