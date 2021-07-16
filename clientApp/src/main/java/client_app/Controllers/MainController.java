package client_app.Controllers;

import client_app.Model.Position;
import client_app.Service.PositionService;
import com.sun.rowset.internal.Row;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

    @FXML
    private TableView<ListView> tableView;


    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(mnItemAdd)) {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/position_edit.fxml"));

            try {
                loader.load();
                Parent parent = loader.getRoot();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(event.getSource().equals(mnItemEdit)){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/position_update.fxml"));

            try {
                loader.load();
                Parent parent = loader.getRoot();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        //This line gets the Stage information


    @FXML
    void initialize() {

//        TableColumn<Row, Number> stepCol = new TableColumn<>("Step");




        List<Position> positions = PositionService.INSTANCE.findAll();

        List<String> names = new ArrayList<>();
        List<Boolean> status = new ArrayList<>();
        List<Button> buttons = new ArrayList<>();

        for(int i = 0; i < positions.size(); i++)
        {
            status.add(positions.get(i).isActive());
            names.add(positions.get(i).getName());
            buttons.add(new Button("edit"));
        }



        ObservableList<String> observableList = FXCollections.observableList(names);


    }
}
