package com.example.wheelsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PopUpRegisterVehic extends AppCompatActivity {

    private EditText editTextVehiModel;
    private EditText editTextVehiNumber;
    private EditText editTextVehiVehiNumber;
    private EditText editTextVehiVehi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_register_vehic);

        DisplayMetrics sizeWindow = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(sizeWindow);

        int width = sizeWindow.widthPixels;
        int height = sizeWindow.heightPixels;

        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.55));

        editTextVehiModel = findViewById(R.id.editTextVehiModel);
        editTextVehiNumber = findViewById(R.id.editTextVehiNumber);
        editTextVehiVehiNumber = findViewById(R.id.editTextVehiVehiNumber);
        editTextVehiVehi = findViewById(R.id.editTextVehiVehi);
    }

    public void popRegister(View v) {
        RegisterActivity.getVehi().setIdUser(RegisterActivity.getUserResponse().getId());
        RegisterActivity.getVehi().setSoat("SOAT TBD");
        RegisterActivity.getVehi().setPropertyCard("PROPERTY CARD TBD");
        RegisterActivity.getVehi().setPhoto("CAR PHOTO TBD");

        RegisterActivity.getVehi().setModel(editTextVehiModel.getText().toString().trim());
        RegisterActivity.getVehi().setPuestos(Integer.decode(editTextVehiNumber.getText().toString().trim()));
        RegisterActivity.getVehi().setDescription(editTextVehiVehi.getText().toString().trim());
        if (RegisterActivity.regitserVehi() == 201) {
            Intent intent = new Intent(PopUpRegisterVehic.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}