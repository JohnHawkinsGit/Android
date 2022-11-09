package com.example.pmdm_2223.iryvolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class act3 extends AppCompatActivity {

    public static final int CODIGO_VUELTA_A3 = 1;
    public static final String MSG2 = "texto";
    TextView tSaludo3;
    Button bVolver2, bCancela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        tSaludo3=findViewById(R.id.tSaludo3);
        bVolver2=findViewById(R.id.bVolver2);
        bCancela2=findViewById(R.id.bCancela2);


        Intent i2=getIntent();
        String saludo2=i2.getStringExtra(act2.texto2);
        tSaludo3.setText(saludo2);


       bVolver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                volver2();
            }
        });
       bCancela2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               cancelar3();
           }
       }
       );
    }

    public void volver2(){
        act3.super.onBackPressed();
    }
    public void cancelar3(){
        String texto=".";
        Intent intento = new Intent(act3.this, MainActivity.class);
        intento.putExtra(texto, "");
        startActivity(intento);
    }
}