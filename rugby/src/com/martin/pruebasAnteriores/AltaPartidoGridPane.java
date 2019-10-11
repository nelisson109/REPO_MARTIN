package com.martin.pruebasAnteriores;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class AltaPartidoGridPane extends Application {

    public void start(Stage stages) throws Exception {
        VBox vBox = new VBox();
        Stage stage = new Stage();
        stage.setTitle("Alta Partido");
        GridPane gridPane = new GridPane();
        Label local = new Label("Mete equipo local");
        TextField tfl = new TextField();
        Label visitante = new Label("Mete equipo visitante");
        TextField tfv = new TextField();
        Label resultado = new Label("Mete el resultado del partido");
        TextField tfResultado = new TextField();
        Label division = new Label("Mete la division del equipo");
        TextField tfDivision = new TextField();
        Label fecha = new Label("Mete la fecha");
        TextField tfFecha = new TextField();
        gridPane.add(local, 0, 0, 1, 1);
        gridPane.add(tfl, 1, 0, 1, 1);
        gridPane.add(visitante, 0, 1, 1, 1);
        gridPane.add(tfv, 1, 1, 1, 1);
        gridPane.add(resultado, 0, 2, 1, 1);
        gridPane.add(tfResultado, 1, 2, 1, 1);
        gridPane.add(division, 0, 3, 1, 1);
        gridPane.add(tfDivision, 1, 3, 1, 1);
        gridPane.add(fecha, 0, 4, 1, 1);
        gridPane.add(tfFecha, 1, 4, 1, 1);
        gridPane.setVgap(10);
        gridPane.setHgap(10);

 /*       ImageView iv = new ImageView(getClass().getResource("resources/android.jpg").toExternalForm());
        iv.setPreserveRatio(true);
        iv.setFitHeight(100);*/

        VBox vb = new VBox(gridPane);

        Scene scene = new Scene(vb, 500, 500);
        stage.setScene(scene);
        stage.show();



/*        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int id = 0;
                id = id + 1;
                String local = tfl.getText();
                String visitante = tfv.getText();
                String div = division.getText();
                String result = resultado.getText();
                Division d = Division.valueOf(div);
                LocalDate localDate = datep.getValue();
                Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


                Partido partido1 = new Partido(id, local, visitante, d, result, date);
                Logica.getInstance().addPartido(partido1);

            }
        });*/




    }
    public static void main(String args []){
        launch();
    }

}
