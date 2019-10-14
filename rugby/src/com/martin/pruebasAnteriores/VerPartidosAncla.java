package com.martin.pruebasAnteriores;

import com.martin.models.Partido;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.martin.logica.Logica;


public class VerPartidosAncla extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TableView tableView = new TableView(Logica.getInstance().getPartidos());
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

        AnchorPane cajaAncla = new AnchorPane();
        AnchorPane.setTopAnchor(tableView, 20d);
        AnchorPane.setBottomAnchor(tableView, 20d);
        AnchorPane.setLeftAnchor(tableView, 20d);
        AnchorPane.setRightAnchor(tableView, 20d);
        cajaAncla.getChildren().add(tableView);

        Scene scene = new Scene(cajaAncla, 600, 300);
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String args []){
        launch();
    }
}
