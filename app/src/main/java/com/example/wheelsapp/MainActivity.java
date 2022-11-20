package com.example.wheelsapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wheelsapp.entities.api_request.UserRequest;
import com.example.wheelsapp.entities.api_responses.AuthResponse;
import com.example.wheelsapp.services.APIAuthService;
import com.example.wheelsapp.utils.RetrofitHelper;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // litestener que escucha por cada caracter cambiado
        /*correoInsti.addTextChangedListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View view) {
                if(correoInsti.text.length==0) correoInsti.setError("Campo vacio")
                println(correoInsti.text.length)
                return false;
            }
        });*/

        /*System.out.println("Hello");
        apiAuthService = RetrofitHelper.getInstance().create(APIAuthService.class);
        UserRequest login = new UserRequest("Admmin@mail.com", "Admmin");
        //Call<AuthResponse> token = authorizationAPI.getToken(login);
        Call<UserRequest> token = apiAuthService.login("Admmin@mail.com", "Admmin");
        System.out.println("ayuda haaaaaaaaa " + token.request().body().toString());
        token.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                try {
                    System.out.println("ayuda haaaaaaaaa");
                    AuthResponse ar = response.body();
                    System.out.println(ar.getToken());
                }catch (Exception ex) {
                    System.out.println("No existe el user");
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {

            }
        });*/
        //val token = authorizationAPI.getToken("Admmin@mail.com", "Admmin")
        //val login = authorizationAPI.getToken(body)

        //println("Si la autenticación esta bien: " + token.body()?.tokenAuth)
        //val token = authorizationAPI.getToken(body)
    }
}