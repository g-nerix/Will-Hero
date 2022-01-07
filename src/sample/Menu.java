package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Menu {
    void show(){
        Stage primarystage = new Stage();
        try {
            Parent root= FXMLLoader.load(getClass().getResource("/sample/mainmenu.fxml"));
            Scene scene= new Scene(root);
            primarystage.setScene(scene);
            primarystage.setHeight(600);
            primarystage.setWidth(1200);
            primarystage.setResizable(false);
            Image icon = new Image("/sample/icon.jpg");
            primarystage.getIcons().add(icon);
            primarystage.show();
            primarystage.setOnCloseRequest(event -> logout(primarystage));
        }
        catch (Exception e) {
            e.printStackTrace();
        }




        }
    public void logout(Stage primarystage){
        Alert a =new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Exit");
        a.setHeaderText("You are about to exit");
        a.setContentText("Are you sure you want to exit?");
        if(a.showAndWait().get()== ButtonType.OK){

            System.out.println("logged out");
            primarystage.close();


        }
    }
}

