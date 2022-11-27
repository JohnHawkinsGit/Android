package com.example.pmdm_2223.listado;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button bAñadir;
    listaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reyclerViewUser = (RecyclerView) findViewById(R.id.listaContenedor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new listaAdapter(Partida.generatePartidas(Partida.PARTIDAS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        ActivityResultLauncher miResultadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{
                    Log.d(TAG,"VUELVE CANCELADO");
                    int code = result.getResultCode();
                    switch (code){
                        case RESULT_CANCELED:
                            break;
                        case Formulario.CREADO:
                            Log.d(TAG,"Se ha añadido una partida");
                            Intent intent = result.getData();
                            break;
                    }
                });

        bAñadir = findViewById(R.id.bAñadir);
        bAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(MainActivity.this, Formulario.class);
                miResultadoLauncher.launch(intento);
            }
        });
    }
}

