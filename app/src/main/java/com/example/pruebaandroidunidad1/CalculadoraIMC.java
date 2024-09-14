package com.example.pruebaandroidunidad1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class CalculadoraIMC extends AppCompatActivity {
    private Button btnCalcular, btnVolver;
    private EditText textPeso, textAltura;
    private RadioButton rbMasculino, rbFemenino;
    private TextView textResultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_imc); // Asegúrate de usar el layout correcto

        // Inicialización de los elementos de la interfaz
        btnCalcular = findViewById(R.id.btnCalcular);
        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        textResultado = findViewById(R.id.textResultado);
        btnVolver = findViewById(R.id.btnVolver);

        // Listener para el botón Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
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

    // Método para calcular el IMC
    private void calcularIMC() {
        // Obtener los valores de los campos de texto
        String pesoStr = textPeso.getText().toString();
        String alturaStr = textAltura.getText().toString();

        // Validar que los campos no estén vacíos
        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            textResultado.setText("Por favor ingresa peso y altura.");
            return;
        }

        // Convertir los valores a números
        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(alturaStr);

        // Validar que la altura no sea cero
        if (altura == 0) {
            textResultado.setText("La altura no puede ser cero.");
            return;
        }

        // Calcular el IMC
        float imc = peso / (altura * altura);

        // Determinar el género seleccionado
        String genero;
        if (rbMasculino.isChecked()) {
            genero = "Masculino";
        } else if (rbFemenino.isChecked()) {
            genero = "Femenino";
        } else {
            textResultado.setText("Por favor selecciona un género.");
            return;
        }

        // Evaluar el IMC y mostrar el resultado
        String resultado = evaluarIMC(imc);
        textResultado.setText(String.format("Género: %s\nIMC: %.2f\n%s", genero, imc, resultado));
    }

    // Método para evaluar el IMC y devolver una categoría
    private String evaluarIMC(float imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}