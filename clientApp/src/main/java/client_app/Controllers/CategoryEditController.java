package client_app.Controllers;

import client_app.Service.CategoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryEditController {

    @FXML
    private TextField txtName;

    @FXML
    private CheckBox checkActive;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

//    @FXML
//    void onButtonClicked(ActionEvent event) {
//
//    }

    @FXML
    void onButtonClicked(ActionEvent event) throws Exception {
        if(event.getSource().equals(btnSave)){

//            Position position = new Position();
//            position.setName(txtName.getText());
//            position.setActive(checkActive.isSelected());
//            CategoryService.INSTANCE.save(position);
//            CategoryService.INSTANCE.closeAddWindow();
//            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//            stage.close();



//            MainController m = new MainController();
//            List<Position> positions = PositionService.INSTANCE.findAll();
//            ObservableList<Position> observableList = FXCollections.observableList(positions);
//            m.setListPositions(observableList);
        }
    }

    @FXML
    void initialize() {

    }
}
