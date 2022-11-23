package com.example.wheelsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Base64;

public class LaunchActivity extends AppCompatActivity {

    public static final String TOKEN_KEY = "TOKEN_KEY";

    private static String decode(String encodedString) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new String(Base64.getUrlDecoder().decode(encodedString));
        }
        return encodedString;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setTheme(R.style.Theme_WheelsApp);

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(TOKEN_KEY);
        try {

            if (sharedPreferences.contains(TOKEN_KEY)) {
                String jwt = sharedPreferences.getString(TOKEN_KEY, TOKEN_KEY).split(" ")[1];
                String[] parts = jwt.split("\\.");

                //JSONObject header = new JSONObject(decode(parts[0]));
                JSONObject payload = new JSONObject(decode(parts[1]));
                if(payload.getLong("exp") > (System.currentTimeMillis()/1000)) {
                    Intent intent = new Intent(this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }

            } else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
