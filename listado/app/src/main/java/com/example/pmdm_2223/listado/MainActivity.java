package com.example.pmdm_2223.listado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

        bAñadir = findViewById(R.id.bAñadir);
        bAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(Partida.generatePartidas(Partida.PARTIDAS_INICIALES));
            }
        });

        //adapter.notifyDataSetChanged();
    }
}

