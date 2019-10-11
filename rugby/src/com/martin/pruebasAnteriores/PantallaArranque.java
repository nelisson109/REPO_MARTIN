package com.martin.pruebasAnteriores;

import com.martin.vistas.AltaPartido;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.martin.logica.Logica;

import static javafx.application.Application.launch;

public class PantallaArranque extends Application {
    @Override
    public void start(Stage stage) throws Exception{
       // Stage stage = new Stage();
        stage.setTitle("Pantalla de Arranque");
        TableView tableView = new TableView(Logica.getInstance().getPartidos());
        AnchorPane.setTopAnchor(tableView,10d);
        AnchorPane.setLeftAnchor(tableView,10d);
        AnchorPane.setRightAnchor(tableView,10d);
        AnchorPane.setBottomAnchor(tableView,10d);



        Button añadir = new Button("Añadir partido");
        Button ver = new Button("Ver lista partidos");
        Button modificar = new Button("Modificar");

        modificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage = new AltaPartido();
              //  int indice = tableViewPartidos.getSelectedModel().getSelectedIndex();
                newStage.show();


            }
        });

        añadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage = new AltaPartido();
            /*    newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.setTitle("Añadir partido");*/
                newStage.show();

            }
        });
        ver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage = new VerPartidos();

             /*   newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.setTitle("Ver lista de partidos");*/
                newStage.show();

            }
        });
        Button borrar = new Button("Borrar");
        borrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage = new Borrar();
                newStage.show();
            }
        });
        Scene scena = new Scene(new VBox(añadir, ver, borrar), 500, 400);
        stage.setScene(scena);
        stage.show();

    }


    public static void main(String args []){
        launch();
    }
}
