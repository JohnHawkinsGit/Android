package com.example.pmdm_2223.iryvolver;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class act2 extends AppCompatActivity {

    public static final int CODIGO_VUELTA_LIMPIAR =2;
    public static final int CODIGO_VUELTA_TEXTO = 3;
    public static final int CODIGO_REVERSO=4;
    public static final String MSG = "texto";
    public static final String ENVIOTEXT0 = "nose";

    TextView tSaludo2;
    Button bEnviar3, bReverse,bVolver1, bCancela;
    EditText eTexto2;
    static String texto2=".";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        tSaludo2 = findViewById(R.id.tSaludo2);
        bEnviar3 = findViewById(R.id.bEnviar3);
        bReverse = findViewById(R.id.bReverse);
        bVolver1 = findViewById(R.id.bVolver1);
        eTexto2 = findViewById(R.id.eTexto2);
        bCancela = findViewById(R.id.bCancela);

        Intent i = getIntent();
        String saludo = i.getStringExtra(MainActivity.texto);
        tSaludo2.setText(saludo);

        ActivityResultLauncher<Intent> enviar3 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Log.d(TAG, "Vuelve cancelado");
                    int code = result.getResultCode();
                    switch (code) {
                        case RESULT_CANCELED:
                            break;
                        case act3.CODIGO_VUELTA_A3:
                            Log.d(TAG, "Vuelve con código, buscar intent");
                            Intent intent1 = result.getData();
                            String mensaje = intent1.getStringExtra(act3.MSG2);
                            tSaludo2.setText(mensaje);
                            break;
                    }
                }
        );
        bVolver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atras();
            }
        });
        bEnviar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento2 = new Intent(act2.this, act3.class);
                intento2.putExtra(texto2, eTexto2.getText().toString());
                startActivity(intento2);
            }
        });


        bReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra(MSG, reverseo(tSaludo2.getText().toString()));
                setResult(CODIGO_REVERSO, data);
                finish();
            }
        });
        bCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelar2();
            }
        });
    }
    public void atras(){
        act2.super.onBackPressed();
    }
    public String reverseo(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public void cancelar2(){
        String texto=".";
        Intent intento = new Intent(act2.this, MainActivity.class);
        intento.putExtra(texto, "");
        startActivity(intento);
    }

}