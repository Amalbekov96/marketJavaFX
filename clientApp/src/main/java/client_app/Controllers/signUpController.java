package client_app.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {

    @FXML
    private Button registBtnGoBack;

    @FXML
    private Button registBtnRegist;

    @FXML
    private Label registUnameLabel;

    @FXML
    private Label registPassLabel;

    @FXML
    private TextField registUnameText;

    @FXML
    private TextField registPassText;

    @FXML
    void onButtonClicked(ActionEvent event) {
        System.out.println("regist");
        if(event.getSource().equals(registBtnGoBack)){

            Stage signStage = (Stage) registBtnGoBack.getScene().getWindow();
            signStage.close();

//            Stage loginStage = new Stage();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/login_page.fxml"));
//
//            try {
//                loader.load();
//                Parent parent = loader.getRoot();
//                loginStage.setScene(new Scene(parent));
//                loginStage.show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }


    }

}
