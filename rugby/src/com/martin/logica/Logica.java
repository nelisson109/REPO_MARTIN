package com.martin.logica;

import com.martin.models.Division;
import com.martin.models.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Logica {

    private ObservableList<Partido> partidos = FXCollections.observableArrayList();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<Partido> partidos1 = new ArrayList<>();
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
    public void escribirObjetos(File fichero){

        try {
          /*  for (Partido p:partidos) {
                partidos2.add(p);
            }*/

            for (int i=0; i<partidos.size(); i++){
                partidos1.add(partidos.get(i));

            }
            escritura = new ObjectOutputStream(new FileOutputStream(fichero));
            escritura.writeObject(partidos1);
        }catch(FileNotFoundException e){
            e.getMessage();
            System.out.println("Error. No se encuentra el fichero");
        }catch(IOException e){
            e.getMessage();
        }finally {
            try{
                if(escritura!=null){
                    escritura.close();
                }
            }catch (IOException e){
                System.out.println("Error al cerrar el fichero para escritura");
            }
        }
    }
    public void leerObjetos(File fichero){
        try {
            lectura = new ObjectInputStream(new FileInputStream(fichero));
            partidos2 = (ArrayList<Partido>) lectura.readObject();
         /*   for (Partido p:partidos2) {
                partidos.add(p);
            }*/
           for (int i=0; i<partidos2.size(); i++){
                partidos.add(partidos2.get(i));
            }
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el fichero para leer");
            e.getLocalizedMessage();
        }catch(IOException e){
            e.getMessage();
            System.out.println("Error de entrada/salida");
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado la clase");
            e.getLocalizedMessage();
        }finally {
            try{
                if(lectura != null){
                    lectura.close();
                }
            }catch(IOException e){
                e.getMessage();
                System.out.println("Error al cerrar el fichero");
            }
        }
    }
}
