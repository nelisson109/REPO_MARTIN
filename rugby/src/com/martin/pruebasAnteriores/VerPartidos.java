package com.martin.pruebasAnteriores;

import com.martin.logica.Partido;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.martin.logica.Logica;


public class VerPartidos extends Stage {
    protected TableView tableView;

    public VerPartidos() {


     /*   ObservableList<Partido> partidos = FXCollections.observableArrayList();
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
        Date date = d.parse("10-09-2019");*/

       /* partidos.add(new Partido(0, "Sporting", "oviedo", Division.SEGUNDA, "5-0", date));
        partidos.add(new Partido(1, "barcelona", "Madrid", Division.PRIMERA, "2-1", date));*/


        tableView = new TableView((ObservableList) Logica.getInstance().getPartidos());
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

/*        Button borrar = new Button("Borrar Partido");
        borrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int indiceBorrar = tableView.getSelectionModel().getSelectedIndex();
                if(indiceBorrar>=0)

                    Logica.getInstance().getPartidos().remove(tableView.getSelectionModel().getSelectedIndex());

            }
        });*/


        Scene scene = new Scene(new VBox(tableView), 600, 300);
        this.setScene(scene);
        this.show();


    }

}
