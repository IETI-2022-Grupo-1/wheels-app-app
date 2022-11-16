package com.example.wheelsapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.wheelsapp.entities.api_request.UserRequest
import com.example.wheelsapp.services.APIAuthService
import com.example.wheelsapp.utils.RetrofitHelper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvRegistro = findViewById<TextView>(R.id.tvRegistro)

        var correoInsti = findViewById<EditText>(R.id.correoInsti)
        // litestener que escucha por cada caracter cambiado
        correoInsti.addTextChangedListener {
            if(correoInsti.text.length==0) correoInsti.setError("Campo vacio")
            println(correoInsti.text.length)
        }

        val authorizationAPI = RetrofitHelper.getInstance().create(APIAuthService::class.java)
        val body = UserRequest("Admmin@mail.com","Admmin")
        val token = authorizationAPI.getToken(body)
        println("Si la autenticación esta bien: " + token.body()?.tokenAuth)
    }


}