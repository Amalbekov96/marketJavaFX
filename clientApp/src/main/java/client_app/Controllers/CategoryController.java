package client_app.Controllers;

import client_app.Model.Category;
import client_app.Service.httpClient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CategoryController {



    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

    @FXML
    private MenuItem mnItemDelete;

    @FXML
    private MenuItem mnItemGoBack;

    @FXML
    private ListView<Category> listCategories;

    @FXML
    void onMenuItemClicked(ActionEvent event) {

        if(event.getSource().equals(mnItemGoBack)){
            goBack(mnItemGoBack);
        } else if(event.getSource().equals(mnItemAdd)){
            addCategory(mnItemAdd);
        } else if(event.getSource().equals(mnItemEdit)){
            updateCategory(mnItemEdit);
        } else if(event.getSource().equals(mnItemDelete)){
            DelteCategory();
        }

    }

    private void DelteCategory() {
        Category category = listCategories.getSelectionModel().getSelectedItem();
        httpClient.INSTANCE.delete(category.getId());
        listCategories.refresh();
        initTableView();
    }

    private void addCategory(MenuItem item){
        Stage owner = (Stage)item.getParentPopup().getOwnerWindow();
        owner.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/category_create.fxml"));
            loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.getRoot()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCategory(MenuItem item){
        Stage owner = (Stage)item.getParentPopup().getOwnerWindow();
        owner.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/category_update.fxml"));
            loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.getRoot()));
            CategoryUpdateController Controller = loader.getController();
            Controller.edit(listCategories.getSelectionModel().getSelectedItem());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void goBack(MenuItem item){
        Stage owner = (Stage)item.getParentPopup().getOwnerWindow();
        owner.close();

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


    private void initTableView() {
        List<Category> categoryList = httpClient.INSTANCE.findAllCa();
        listCategories.setItems(FXCollections.observableArrayList(categoryList));
    }

    private void initTableViewProperties() {
        listCategories.setCellFactory(category->new ListCell<Category>(){
            @Override
            protected void updateItem(Category c,boolean empty){
                super.updateItem(c,empty);
                if (empty||c==null||c.getName()==null){
                    setText(null);
                }else {
                    setText(c.getName());
                }
                if (c!=null&& !c.getActive()){
                    setStyle("-fx-background-color: red");
                }else {
                    setStyle("");
                }
            }
        });
    }

    @FXML
    void initialize(){
        initTableViewProperties();
        initTableView();
    }



}
