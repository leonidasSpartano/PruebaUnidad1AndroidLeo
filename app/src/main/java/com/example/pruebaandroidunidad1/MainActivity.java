package com.example.pruebaandroidunidad1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnCalculadoraIMC, btnNumeroAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Asigna los botones
        btnCalculadoraIMC = findViewById(R.id.btnCaluladoraIMC);
        btnNumeroAleatorio = findViewById(R.id.btnNumeroAleatorio);

        // Configurar los listeners para los botones
        btnCalculadoraIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de CalculadoraIMC
                Intent intent = new Intent(MainActivity.this, CalculadoraIMC.class);
                startActivity(intent);
            }
        });

        btnNumeroAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de NumeroAleatorio
                Intent intent = new Intent(MainActivity.this, Numero_aleatorio.class);
                startActivity(intent);
            }
        });

        // Configuración para el comportamiento EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}