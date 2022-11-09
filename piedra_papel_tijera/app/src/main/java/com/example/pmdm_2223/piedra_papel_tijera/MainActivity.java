package com.example.pmdm_2223.piedra_papel_tijera;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int contJug;
    int contMaq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lMaqResult=findViewById(R.id.lMaqResult);
        TextView lResultJug=findViewById(R.id.lResultJug);
        TextView lResultMaq=findViewById(R.id.lResultMaq);
        TextView lGanar=findViewById(R.id.lGanar);
        ImageButton bFuego=findViewById(R.id.bFuego);
        ImageButton bAgua=findViewById(R.id.bAgua);
        ImageButton bHoja=findViewById(R.id.bHoja);
        Button bReset=findViewById(R.id.bReset);

        bReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contJug=0;
                        contMaq=0;
                        lResultJug.setText(contJug+"");
                        lResultMaq.setText(contMaq+"");
                    }
                }
        );

        bAgua.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num=aleatorio();

                        if (num == 1) {
                            lGanar.setText(R.string.ganar);
                            lMaqResult.setText(R.string.jugoFuego);
                            contJug++;
                            lResultJug.setText(contJug+"");
                            lGanar.setTextColor(Color.GREEN);
                        } else if (num == 2) {
                            lGanar.setText(R.string.perder);
                            contMaq++;
                            lResultMaq.setText(contMaq+"");
                            lMaqResult.setText(R.string.jugoHoja);
                            lGanar.setTextColor(Color.RED);

                        } else if (num == 3) {
                            lGanar.setText(R.string.empate);
                            lMaqResult.setText(R.string.jugoAgua);
                            lGanar.setTextColor(Color.BLACK);

                        }
                    }
                }
        );

        bFuego.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num=aleatorio();
                        switch (num){
                            case 1:
                                lGanar.setText(R.string.empate);
                                lMaqResult.setText(R.string.jugoFuego);
                                lGanar.setTextColor(Color.BLACK);
                                break;
                            case 2:
                                lGanar.setText(R.string.ganar);
                                contJug++;
                                lResultJug.setText(contJug+"");
                                lMaqResult.setText(R.string.jugoHoja);
                                lGanar.setTextColor(Color.GREEN);
                                break;
                            case 3:
                                lGanar.setText(R.string.perder);
                                contMaq++;
                                lResultMaq.setText(contMaq+"");
                                lMaqResult.setText(R.string.jugoAgua);
                                lGanar.setTextColor(Color.RED);

                                break;
                        }
                    }
                }
        );

        bHoja.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num=aleatorio();
                        switch (num){
                            case 1:
                                lGanar.setText(R.string.perder);
                                lMaqResult.setText(R.string.jugoFuego);
                                contMaq++;
                                lResultMaq.setText(contMaq+"");
                                lGanar.setTextColor(Color.RED);

                                break;
                            case 2:
                                lGanar.setText(R.string.empate);
                                lMaqResult.setText(R.string.jugoHoja);
                                lGanar.setTextColor(Color.BLACK);
                                break;
                            case 3:
                                lGanar.setText(R.string.ganar);
                                lMaqResult.setText(R.string.jugoAgua);
                                contJug++;
                                lResultJug.setText(contJug+"");
                                lGanar.setTextColor(Color.GREEN);

                                break;
                        }
                    }
                }
        );
    }
    public int aleatorio(){
        int i= (int)(Math.random()*3+1);
        return i;
    }
}