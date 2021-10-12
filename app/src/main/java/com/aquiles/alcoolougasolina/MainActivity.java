package com.aquiles.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean resultado = validarCampos(precoAlcool, precoGasolina);

        if (resultado) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if ((valorAlcool / valorGasolina) >= 0.7) {
                txtResultado.setText("e melhor utilizar gasolina");
            } else {
                txtResultado.setText("e melhor utilizar alcool");
            }

        } else {
            txtResultado.setText("Preencha os preços primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGalosina) {
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGalosina == null || pGalosina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}