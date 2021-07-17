package client_app.Controllers;

import client_app.Model.Category;
import client_app.Service.CategoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class CategoryEditController {

    @FXML
    private TextField txtName;

    @FXML
    private CheckBox checkActive;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) throws Exception {
        if(event.getSource().equals(btnSave)){

            Category category = new Category();

            System.out.println(txtName.getText());

            category.setName(txtName.getText());
            category.setActive(checkActive.isSelected());
            CategoryService.INSTANCE.save(category);
            if (category == null){
                showALert("Не удалось сохранить");
                return;
            }else {
                showALert("Успешно");
            }

            goBack(btnSave);

        } else if(event.getSource().equals(btnCancel)){
                goBack(btnCancel);
        }

    }


    private void showALert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,message);
        alert.show();
    }

    private void goBack(Button btn){
        Stage createMenu = (Stage) btn.getScene().getWindow();
        createMenu.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/category_menu.fxml"));
            loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.getRoot()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void initialize() {

    }
}
