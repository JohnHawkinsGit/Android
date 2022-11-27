package com.example.pmdm_2223.listado;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PartidaDAO {
    @Query("SELECT * FROM partidas")
    List<Partida> getAll();

    @Query("SELECT * FROM partidas WHERE uid IN (:partidaIds)")
    List<Partida> loadAllByIds(int[] partidaIds);

    @Query("SELECT * FROM partidas WHERE nomJuego LIKE nomJuego")
    Partida findByName(String juego);

    @Insert
    void insertAll(Partida... partidas);

    @Update
     void update(Partida partida);

    @Delete
    void delete(Partida partida);
}
