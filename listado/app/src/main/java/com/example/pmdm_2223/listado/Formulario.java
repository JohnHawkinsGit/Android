package com.example.pmdm_2223.listado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Formulario extends AppCompatActivity {
    public static final int CREADO=1;

    Button bCrear, bCancelar;
    EditText eJ1,eJ2,eJ3,eJ4,eP1,eP2,eP3,eP4,eJuego;
    AppDatabase db;
    PartidaDAO partidaDao;
    Datos info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        eJ1=findViewById(R.id.eJ1);
        eJ2=findViewById(R.id.eJ2);
        eJ3=findViewById(R.id.eJ3);
        eJ4=findViewById(R.id.eJ4);
        eP1=findViewById(R.id.eP1);
        eP2=findViewById(R.id.eP2);
        eP3=findViewById(R.id.eP3);
        eP4=findViewById(R.id.eP4);
        eJuego=findViewById(R.id.eJuego);
        bCancelar=findViewById(R.id.bCancelar);
        bCrear=findViewById(R.id.bCrear);

        TextView.OnEditorActionListener manejador = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                InputMethodManager imm = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                }
                imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                return false;
            }
        };
        eJ1.setOnEditorActionListener(manejador);
        eJ2.setOnEditorActionListener(manejador);
        eJ3.setOnEditorActionListener(manejador);
        eJ4.setOnEditorActionListener(manejador);
        eP1.setOnEditorActionListener(manejador);
        eP2.setOnEditorActionListener(manejador);
        eP3.setOnEditorActionListener(manejador);
        eP4.setOnEditorActionListener(manejador);
        eJuego.setOnEditorActionListener(manejador);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "partidas").allowMainThreadQueries().build();
        partidaDao = db.partidaDAO();

        bCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crear();
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void crear(){
        Intent form=new Intent(this, listaAdapter.class);
        info=new Datos(eJuego.getText().toString(),eJ1.getText().toString(),eJ2.getText().toString(),eJ3.getText().toString(),eJ4.getText().toString(),
                Integer.parseInt(eP1.getText().toString()), Integer.parseInt(eP2.getText().toString()), Integer.parseInt(eP3.getText().toString()), Integer.parseInt(eP4.getText().toString()));
        form.putExtra("objeto", (CharSequence) info);
        startActivity(form);

    }
    public void onClick(View view){
        finish();
    }

}