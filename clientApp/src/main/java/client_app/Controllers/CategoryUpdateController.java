package client_app.Controllers;

import client_app.Model.Category;
import client_app.Service.CategoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class CategoryUpdateController {

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnUpdateCancel;


    @FXML
    private TextField txtName;

    @FXML
    private CheckBox checkActive;


    @FXML
    void onButtonClicked(ActionEvent event) {
        if(event.getSource().equals(btnUpdate)){

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

            goBack(btnUpdate);

        } else if(event.getSource().equals(btnUpdateCancel)){
            goBack(btnUpdateCancel);
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
    void edit(Category category){
        Category category1 = CategoryService.INSTANCE.findById(category.getId());
        txtName.setText(category1.getName());
        checkActive.setSelected(category1.getActive());
    }

}
