package com.example.wheelsapp;

import static com.example.wheelsapp.LaunchActivity.TOKEN_KEY;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wheelsapp.databinding.ActivityMain2Binding;
import com.example.wheelsapp.entities.api_responses.UserResponse;
import com.example.wheelsapp.services.UserService;
import com.example.wheelsapp.utils.RetrofitHelper;
import com.example.wheelsapp.utils.RoleEnum;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Base64;

import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private static String userId;
    private static final ArrayList<RoleEnum> userRoles = new ArrayList<>();
    private static RoleEnum currentRole;
    private static Boolean isDriver;
    private static JSONObject payload;
    private static UserResponse user;
    private static String jwt;
    UserService userService;
    private ActivityMain2Binding binding;

    private static String decode(String encodedString) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new String(Base64.getUrlDecoder().decode(encodedString));
        }
        return encodedString;
    }

    public static String getUserId() {
        return userId;
    }

    public static ArrayList<RoleEnum> getUserRoles() {
        return userRoles;
    }

    public static RoleEnum getCurrentRole() {
        return currentRole;
    }

    public static Boolean getDriver() {
        return isDriver;
    }

    public static JSONObject getPayload() {
        return payload;
    }

    public static UserResponse getUser() {
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        parseJwt();
        parseUser();
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    private void parseJwt() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
            jwt = sharedPreferences.getString(TOKEN_KEY, TOKEN_KEY).split(" ")[1];
            String[] parts = jwt.split("\\.");

            //JSONObject header = new JSONObject(decode(parts[0]));
            payload = new JSONObject(decode(parts[1]));
            //String signature = decode(parts[2]);
            userId = payload.getString("sub");
            JSONArray jArray = payload.getJSONArray("claims");
            for (int i = 0; i < jArray.length(); i++) {
                userRoles.add(jArray.getString(i) == RoleEnum.DRIVER.toString() ? RoleEnum.DRIVER : jArray.getString(i) == RoleEnum.ADMIN.toString() ? RoleEnum.ADMIN : RoleEnum.PASSENGER);
            }
            currentRole = userRoles.contains(RoleEnum.DRIVER) ? RoleEnum.DRIVER : RoleEnum.PASSENGER;
            isDriver = userRoles.contains(RoleEnum.DRIVER.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseUser() {
        try {
            userService = RetrofitHelper.getInstance().create(UserService.class);
            Response<UserResponse> response = userService.getUser(userId, ("Bearer " + jwt)).execute();
            user = response.body();
            System.out.println("MainActivity2 " + user.getLastName() + " " + user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logOut(View V) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("TOKEN_KEY");
        editor.commit();
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public ActivityMain2Binding getBinding() {
        return binding;
    }
}