package com.martin.logica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;

public class Logica {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static Logica INSTANCE = null;

    private Logica() {

    }

    public static Logica getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Logica();

        return INSTANCE;
    }

    private ObservableList<Partido> partidos = FXCollections.observableArrayList();

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }
    public void borrarPartido(int indiceBorrar){
        partidos.remove(indiceBorrar);
    }
    public void modificarPartido(Partido partido, int posicion){
        partidos.set(posicion, partido);

    }

    public ObservableList<Partido> getPartidos() {
        return partidos;
    }
}
