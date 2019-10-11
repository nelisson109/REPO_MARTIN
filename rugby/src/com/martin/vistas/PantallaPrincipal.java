package com.martin.vistas;

import com.martin.logica.Partido;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.martin.logica.Logica;
import com.martin.pruebasAnteriores.VerPartidos;

import java.text.SimpleDateFormat;

public class PantallaPrincipal extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        //comentando
       // Stage stage = new Stage();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        stage.setTitle("Pantalla Principal");
        TableView tableView = new TableView(Logica.getInstance().getPartidos());
        AnchorPane.setTopAnchor(tableView,10d);
        AnchorPane.setLeftAnchor(tableView,10d);
        AnchorPane.setRightAnchor(tableView,10d);
        AnchorPane.setBottomAnchor(tableView,10d);

        TableColumn<String, Partido> column1 = new TableColumn<>("equipoLocal");
        TableColumn<String, Partido> column2 = new TableColumn<>("equipoVisitante");
        TableColumn<String, Partido> column3 = new TableColumn<>("Division");
        TableColumn<String, Partido> column5 = new TableColumn<>("resultado");
        TableColumn<String, Partido> column4 = new TableColumn<>("fecha");
        column1.setCellValueFactory(new PropertyValueFactory<>("equipoLocal"));
        column2.setCellValueFactory(new PropertyValueFactory<>("equipoVisitante"));
        column3.setCellValueFactory(new PropertyValueFactory<>("d"));
        column5.setCellValueFactory(new PropertyValueFactory<>("resultado"));
        column4.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableView.getColumns().addAll(column1, column2, column3, column5, column4);



        Button añadir = new Button("Añadir partido");
        Button ver = new Button("Ver lista partidos");
        Button modificar = new Button("Modificar");

        modificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int indice = tableView.getSelectionModel().getSelectedIndex();
                Partido partido = Logica.getInstance().getPartidos().get(indice);

                AltaPartido altaPartido = new AltaPartido(partido, indice);
                altaPartido.show();
            }
        });

        añadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            /*    Stage newStage = new AltaPartido();
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.setTitle("Añadir partido");
                newStage.show();*/
                AltaPartido altaPartido = new AltaPartido();
                altaPartido.show();

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
                int indiceBorrar = tableView.getSelectionModel().getSelectedIndex();
                if (indiceBorrar>=0)
                    Logica.getInstance().borrarPartido(indiceBorrar);
            }
        });
        ImageView imagen = new ImageView(getClass().getResource("resources/rugby.jpg").toExternalForm());
        imagen.setPreserveRatio(true);
        imagen.setFitHeight(50);

        AnchorPane anchorPane = new AnchorPane(tableView);
        VBox vBox = new VBox(anchorPane, imagen);
        vBox.getChildren().add(ver);
        vBox.getChildren().add(borrar);
        vBox.getChildren().add(añadir);
        vBox.getChildren().add(modificar);
        //hola

        vBox.setSpacing(10);
        Scene scena = new Scene(vBox, 500, 700);
        stage.setScene(scena);
        stage.show();

    }


    public static void main(String args []){
        launch();
    }
}
