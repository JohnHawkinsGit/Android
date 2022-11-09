package com.example.pmdm_2223.listado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Partida {
        public String j1,j2,j3,j4;
        public String pto1,pto2,pto3,pto4;
        public String juego, jImagen;

        private static final double MIN_PTOS = 2;
        private static final double MAX_PTOS = 9;
        public static final int PARTIDAS_INICIALES = 10;
        private static ArrayList<String> nombres = new ArrayList<String>(Arrays.asList(new String[]{"Jorge", "Carlos", "Jose", "Bea", "Luis", "Joseto", "Gon", "Andres", "Patri", "Victor"}));
        private static ArrayList<String> juegos = new ArrayList<String>(Arrays.asList(new String[]{"Catan", "Carcassonne", "Dixit", "The Island", "SmallWorld", "Bunny Kingdom"}));
        public static Partida generatePartida(){
            Collections.shuffle(nombres);
            Collections.shuffle(juegos);
            Partida p = new Partida();
            p.j1 = nombres.get(0);
            p.j2 = nombres.get(1);
            p.j3 = nombres.get(2);
            p.j4 = nombres.get(3);
            p.pto1 = ""+(int)(MIN_PTOS+Math.random()*MAX_PTOS);
            p.pto2 = ""+(int)(MIN_PTOS+Math.random()*MAX_PTOS);
            p.pto3 = ""+(int)(MIN_PTOS+Math.random()*MAX_PTOS);
            p.pto4 = ""+(int)(MIN_PTOS+Math.random()*MAX_PTOS);
            p.juego=juegos.get(0);




            return p;
        }

        public static Partida[] generatePartidas(int n) {
            Partida[] partidas = new Partida[n];
            for(int i = 0; i< n; i++){
                partidas[i] = Partida.generatePartida();
            }
            return partidas;
        }
}
