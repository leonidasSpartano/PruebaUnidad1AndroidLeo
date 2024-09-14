package com.example.pruebaandroidunidad1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Numero_aleatorio extends AppCompatActivity {
    private Button btnVolver, btnIniciar;
    private TextView textNResultado;
    private EditText textNinicial, textNfinal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numero_aleatorio); // Asegúrate de usar el layout correcto

        // Inicialización de los elementos de la interfaz
        btnVolver = findViewById(R.id.btnVolver);
        btnIniciar = findViewById(R.id.btnIniciar);
        textNResultado = findViewById(R.id.textNResultado);
        textNinicial = findViewById(R.id.textNinicial);
        textNfinal = findViewById(R.id.textNfinal);

        // Listener para el botón Iniciar
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarNumeroAleatorio();
            }
        });

        // Listener para el botón Volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a MainActivity
                finish(); // Termina la actividad actual y regresa a la anterior (MainActivity)
            }
        });
    }

    // Método para generar un número aleatorio dentro del rango
    private void generarNumeroAleatorio() {
        // Obtener los valores de los campos de texto
        String numInicialStr = textNinicial.getText().toString();
        String numFinalStr = textNfinal.getText().toString();

        // Validar que los campos no estén vacíos
        if (numInicialStr.isEmpty() || numFinalStr.isEmpty()) {
            textNResultado.setText("Por favor ingresa ambos números.");
            return;
        }

        // Convertir los valores a números enteros
        int numInicial = Integer.parseInt(numInicialStr);
        int numFinal = Integer.parseInt(numFinalStr);

        // Validar que el número inicial no sea mayor que el número final
        if (numInicial > numFinal) {
            textNResultado.setText("El número inicial no puede ser mayor que el número final.");
            return;
        }

        // Generar un número aleatorio dentro del rango
        int numeroAleatorio = (int) (Math.random() * (numFinal - numInicial + 1)) + numInicial;

        // Mostrar el número aleatorio
        textNResultado.setText("Número aleatorio: " + numeroAleatorio);
    }
}
