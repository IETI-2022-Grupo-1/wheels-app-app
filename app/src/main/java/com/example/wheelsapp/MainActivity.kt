package com.example.wheelsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

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
        correoInsti.setSelection(3)

    }
}