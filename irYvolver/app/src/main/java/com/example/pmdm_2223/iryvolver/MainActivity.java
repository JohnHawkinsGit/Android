package com.example.pmdm_2223.iryvolver;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class    MainActivity extends AppCompatActivity {
    Button bEnviar2;
    EditText eNombre;
    Button bSalir;
    static String texto=".";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bEnviar2 = findViewById(R.id.bEnviar2);
        eNombre = findViewById(R.id.eNombre);
        bSalir = findViewById(R.id.bSalir);

        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Log.d(TAG, "Vuelve cancelado");
                    int code = result.getResultCode();
                    switch (code) {
                        case RESULT_CANCELED:
                            break;
                        case act2.CODIGO_VUELTA_LIMPIAR:
                            Log.d(TAG, "limpiar texto");
                            eNombre.setText("");
                            break;
                        case act2.CODIGO_VUELTA_TEXTO:
                            Log.d(TAG, "vuelve con codigo, buscar intent");
                            Intent intent = result.getData();
                            texto = intent.getStringExtra(act2.MSG);
                            eNombre.setText(texto);
                            break;
                        case act2.CODIGO_REVERSO:
                            Log.d(TAG, "Vuelve con el texto reverso");
                            Intent intent1 = result.getData();
                            texto = intent1.getStringExtra(act2.MSG);
                            eNombre.setText(texto);
                            break;
                    }
                }
    );

        bEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, act2.class);
                intent.putExtra(texto, eNombre.getText().toString());
                someActivityResultLauncher.launch(intent);
            }
        });
    }
}