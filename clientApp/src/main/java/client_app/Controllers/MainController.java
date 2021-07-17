package client_app.Controllers;

import client_app.Main;
import client_app.Model.Product;
import client_app.Service.ProductService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.List;

public class MainController {

    @FXML
    MenuBar myMenuBar;

    @FXML
    private MenuItem mnItemCategories;

    @FXML
    private MenuItem mnItemAddProduct;

    @FXML
    private MenuItem mnItemEditProduct;

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
        }

    }

    private void initTableView() {
        List<Product> productList = ProductService.INSTANCE.findAll();
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

    @FXML
    void initialize() {
        initTableView();
        initTableViewProperties();
    }



}
