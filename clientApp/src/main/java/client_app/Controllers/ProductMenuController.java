package client_app.Controllers;

import client_app.Model.Product;
import client_app.Service.httpClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ProductMenuController {

    @FXML
    private MenuItem mnItemCategories;

    @FXML
    private MenuItem mnItemAddProduct;

    @FXML
    private MenuItem mnItemEditProduct;

    @FXML
    private MenuItem mnItemDeleteProduct;

    @FXML
    private MenuItem LogOut;

    @FXML
    private TableView<Product> tblViewProducts;

    @FXML
    private TableColumn<Product, Long> colmnId;

    @FXML
    private TableColumn<Product, String> colmnProductName;

    @FXML
    private TableColumn<Product, String> colmnCategoryName;

    @FXML
    private TableColumn<Product, String> colmnPrice;

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if(event.getSource().equals(mnItemCategories)){
            categoryTable(mnItemCategories);
        } else if(event.getSource().equals(mnItemAddProduct)){
            addProduct(mnItemAddProduct);
        } else if(event.getSource().equals(mnItemEditProduct)){
            updateProduct();
        } else if(event.getSource().equals(mnItemDeleteProduct)){
            deleteProduct(tblViewProducts.getSelectionModel().getSelectedItem().getId());
        }

    }

    private void deleteProduct(Long id) {
        httpClient.INSTANCE.deleteByIdPr(id);
    }

    private void initTableView() {
        List<Product> productList = httpClient.INSTANCE.findAllPr();
        tblViewProducts.setItems(FXCollections.observableArrayList(productList));
    }

    private void initTableViewProperties() {
        colmnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colmnProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colmnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colmnCategoryName.setCellValueFactory(column->new SimpleStringProperty(column.getValue().getCategory().getName()));
    }

    private void categoryTable(MenuItem item){
        Stage owner = (Stage)item.getParentPopup().getOwnerWindow();
        owner.close();

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


    private void addProduct(MenuItem item){
        Stage owner = (Stage)item.getParentPopup().getOwnerWindow();
        owner.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/product_create.fxml"));
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
        initTableView();
        initTableViewProperties();
    }



    private void updateProduct() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/product_create.fxml"));
        try {
            loader.load();
            Parent parent = loader.getRoot();
            stage.setTitle("Редактирование продукта");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            ProductEditController productEditController = loader.getController();
            productEditController.setProduct(tblViewProducts.getSelectionModel().getSelectedItem());
            productEditController.setUpdateOrCreate(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
