package com.example.pmdm_2223.miapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Calculadora extends AppCompatActivity {

    TextView lResultado;
    Button bCalcular;
    RadioButton rSuma,rResta,rMult,rDiv;
    EditText eNum1, eNum2;
    public final int ZERO=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        bCalcular=findViewById(R.id.bCalcular);
        lResultado =findViewById(R.id.idAPIlabel);
        eNum1=findViewById(R.id.eNum1);
        eNum2=findViewById(R.id.eNum2);
        rSuma=findViewById(R.id.rSuma);
        rResta=findViewById(R.id.rResta);
        rMult=findViewById(R.id.rMult);
        rDiv=findViewById(R.id.rDiv);


        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rSuma.isChecked()) {
                    Call<Resultado> llamada = MatesAPI.getInstance().suma(Integer.parseInt(eNum1.getText().toString()), Integer.parseInt(eNum2.getText().toString()));
                    llamada.enqueue(new Callback<Resultado>() {
                        @Override
                        public void onResponse(Call<Resultado> call, Response<Resultado> response) {

                            lResultado.setText(response.body().respuesta);
                        }

                        @Override
                        public void onFailure(Call<Resultado> call, Throwable t) {
                            lResultado.setText("error" + t.getMessage());
                        }
                    });
                }
                if(rResta.isChecked()) {
                    Call<Resultado> llamada = MatesAPI.getInstance().resta(Integer.parseInt(eNum1.getText().toString()), Integer.parseInt(eNum2.getText().toString()));
                    llamada.enqueue(new Callback<Resultado>() {
                        @Override
                        public void onResponse(Call<Resultado> call, Response<Resultado> response) {

                            lResultado.setText(response.body().respuesta);
                        }

                        @Override
                        public void onFailure(Call<Resultado> call, Throwable t) {
                            lResultado.setText("error" + t.getMessage());
                        }
                    });
                }
                if(rMult.isChecked()) {
                    Call<Resultado> llamada = MatesAPI.getInstance().mult(Integer.parseInt(eNum1.getText().toString()), Integer.parseInt(eNum2.getText().toString()));
                    llamada.enqueue(new Callback<Resultado>() {
                        @Override
                        public void onResponse(Call<Resultado> call, Response<Resultado> response) {

                            lResultado.setText(response.body().respuesta);
                        }

                        @Override
                        public void onFailure(Call<Resultado> call, Throwable t) {
                            lResultado.setText("error" + t.getMessage());
                        }
                    });
                }
                if(rDiv.isChecked()) {
                    if(Integer.parseInt(eNum2.getText().toString())==ZERO){
                        Context context = getApplicationContext();
                        CharSequence text = "No se puede dividir entre 0";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }else{
                        Call<Resultado> llamada = MatesAPI.getInstance().div(Integer.parseInt(eNum1.getText().toString()), Integer.parseInt(eNum2.getText().toString()));
                            llamada.enqueue(new Callback<Resultado>() {
                            @Override
                            public void onResponse(Call<Resultado> call, Response<Resultado> response) {

                                lResultado.setText(response.body().respuesta);
                            }

                            @Override
                            public void onFailure(Call<Resultado> call, Throwable t) {
                                lResultado.setText("error" + t.getMessage());
                            }
                        });
                    }
                }
            }
        });
    }
}