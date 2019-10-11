package com.martin.pruebasAnteriores;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ventana2 extends Application {

    public void start(Stage stage) throws Exception{
        VBox vBox = new VBox();
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Sporting", "Barcelona", "Atletic Bilbao");
        comboBox.setPromptText("Equipo Local");
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll("Oviedo", "Madrid", "R. Sociedad");
        comboBox1.setPromptText("Equipo visitante");
        ComboBox<String> comboBox2 = new ComboBox<>();
        Label label = new Label("Mete resultado");
        TextField tf = new TextField();


        

        HBox hBox = new HBox();



        HBox hb = new HBox();
        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button("Cancelar");
        hb.getChildren().add(aceptar);
        hb.getChildren().add(cancelar);


        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        vBox.getChildren().add(comboBox);
        vBox.getChildren().add(comboBox1);
        vBox.getChildren().add(comboBox2);
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hb);

        Scene scene = new Scene(vBox, 200, 200);
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String args[]){
        launch(args);
    }
}
