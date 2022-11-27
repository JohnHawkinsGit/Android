package com.example.pmdm_2223.listado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class listaAdapter extends RecyclerView.Adapter<listaAdapter.ViewHolder> {

    private ArrayList<Partida> datos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iJuego;
        private final TextView tj1,tj2,tj3,tj4;
        private final TextView tPJ1,tPJ2,tPJ3,tPJ4;
        private final TextView tJuego;
        Datos informacion;
        Bundle bundle;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            iJuego=(ImageView) view.findViewById(R.id.iJuego);
            tJuego= (TextView) view.findViewById(R.id.tJuego);
            tj1 = (TextView) view.findViewById(R.id.tJ1);
            tj2 = (TextView) view.findViewById(R.id.tJ2);
            tj3 = (TextView) view.findViewById(R.id.tJ3);
            tj4 = (TextView) view.findViewById(R.id.tJ4);
            tPJ1 = (TextView) view.findViewById(R.id.tPJ1);
            tPJ2 = (TextView) view.findViewById(R.id.tPJ2);
            tPJ3 = (TextView) view.findViewById(R.id.tPJ3);
            tPJ4 = (TextView) view.findViewById(R.id.tPJ4);
            bundle=getIntent().getExtras();
            informacion=(Datos)bundle.getSerializable("objeto");
        }

        public void setInfo(Partida partida) {

            tJuego.setText(partida.juego);
            if (tJuego.getText()=="Catan"){
                iJuego.setImageResource(R.drawable.catan);
            }
            if (tJuego.getText()=="Carcassonne"){
                iJuego.setImageResource(R.drawable.carcassonne);
            }
            if (tJuego.getText()=="Bunny Kingdom"){
                iJuego.setImageResource(R.drawable.bunny);
            }
            if (tJuego.getText()=="SmallWorld"){
                iJuego.setImageResource(R.drawable.smallworld);
            }
            if (tJuego.getText()=="Dixit"){
                iJuego.setImageResource(R.drawable.dixit);
            }
            if (tJuego.getText()=="The Island"){
                iJuego.setImageResource(R.drawable.theisland);
            }
            tj1.setText(informacion.getJ1());
            tj2.setText(informacion.getJ2());
            tj3.setText(informacion.getJ3());
            tj4.setText(informacion.getJ4());
            tPJ1.setText(informacion.getPto1());
            tPJ2.setText(informacion.getPto2());
            tPJ3.setText(informacion.getPto3());
            tPJ4.setText(informacion.getPto4());
        }
    }

    public listaAdapter(Partida[] dataSet) {
        datos = new ArrayList<Partida>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lineajuegos, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
            viewHolder.setInfo(datos.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(Partida[] dataSet){
        datos.addAll(Arrays.asList( dataSet));
        notifyDataSetChanged();
    }
}
