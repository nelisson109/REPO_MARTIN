package com.martin.logica;

import com.martin.models.Division;
import com.martin.models.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Logica {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<Partido> partidos2 = new ArrayList<Partido>();
    private ObjectInputStream lectura;
    private ObjectOutputStream escritura;
    private static Logica INSTANCE = null;

    private Logica() {
//probando git por enesima vez
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
    public ObservableList filtrar(Division f){
        ObservableList<Partido> listaFiltrada = FXCollections.observableArrayList();
        if(f.equals(Division.PRIMERA) || f.equals(Division.SEGUNDA) || f.equals(Division.TERCERA)){
            for(int i = 0; i<partidos.size(); i++){
                if(partidos.get(i).getD().equals(f)){
                    listaFiltrada.add(partidos.get(i));
                }
            }
            return listaFiltrada;
        }
        else {
            return partidos;
        }
    }
    public void escribirObjetos(){
        try {
            escritura = new ObjectOutputStream(new FileOutputStream("ficheroPartidos.dat", true));
            escritura.writeObject(partidos);
        }catch(FileNotFoundException e){
            e.getMessage();
        }catch(IOException e){
            e.getMessage();
        }finally {
            try{
                if(escritura!=null){
                    escritura.close();
                }
            }catch (IOException e){
                System.out.println("Error al cerrar el fichero");
            }
        }
    }
}
