package client_app.Controllers;

import client_app.Model.Category;
import client_app.Model.Product;
import client_app.Service.httpClient;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;

public class ProductEditController {

        private Product product;

        public void setProduct(Product product) {
                this.product = product;
        }

        @FXML
        private Button categoryGoBackBtn;

        @FXML
        private Button categoryCreateBtn;

        @FXML
        private TextField txtName;

        @FXML
        private Spinner<Double> spinner;

        @FXML
        private ComboBox<Category> comboBox;

        private Boolean UpdateOrCreate = false;

        @FXML
        void initialize() {
                if(UpdateOrCreate){
                        txtName.setText(product.getName());
                        initCmbCategories();
                        initSpinner();
                        categoryCreateBtn.setText("Update");
                } else {
                        initCmbCategories();
                        initSpinner();
                }

        }

        @FXML
        void onButtonClick(ActionEvent event) {

                if(event.getSource().equals(categoryGoBackBtn)){
                        goBack(categoryGoBackBtn);
                } else if(event.getSource().equals(categoryCreateBtn)){
                        saveCategory();
                }
        }


        private void goBack(Button button){
                Stage createMenu = (Stage) button.getScene().getWindow();
                createMenu.close();

                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/main.fxml"));
                        loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(loader.getRoot()));
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        private void initSpinner() {
                spinner.setEditable(true);
                spinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,10000000,0,2));
        }

        private void showALert(String message, double time){
                Alert alert = new Alert(Alert.AlertType.ERROR,message);
                alert.show();
                PauseTransition delay = new PauseTransition(Duration.seconds(time));
                delay.setOnFinished( event -> alert.close() );
                delay.play();
        }

        private void timer(Stage stage, double time){
                PauseTransition delay = new PauseTransition(Duration.seconds(time));
                delay.setOnFinished( event -> stage.show() );
                delay.play();
        }

        private void initCmbCategories() {
                List<Category> categoryList = httpClient.INSTANCE.findAllCa();
                comboBox.setConverter(new StringConverter<Category>() {
                        @Override
                        public String toString(Category object) {
                                return object.getName();
                        }

                        @Override
                        public Category fromString(String string) {
                                return null;
                        }
                });
                comboBox.setItems(FXCollections.observableArrayList(categoryList));
        }

        private void saveCategory() {
                product.setName(txtName.getText());
                product.setPrice(Double.valueOf(spinner.getEditor().getText()));
                product.setCategory(httpClient.INSTANCE.findByIdCa(comboBox.getSelectionModel().getSelectedItem().getId()));
                httpClient.INSTANCE.save(product);
        }


        public void setUpdateOrCreate(Boolean updateOrCreate) {
                UpdateOrCreate = updateOrCreate;
        }
}
