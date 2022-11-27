package com.example.pmdm_2223.listado;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Partida.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PartidaDAO partidaDAO();
}