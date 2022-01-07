

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import sample.Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class mainmenu implements Initializable {
    // @FXML
    // private Button play;
    // @FXML
    // private Button exit;
    // @FXML
    // private Button load;


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane sPane;

    public void play(MouseEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/sample/NEWGAME.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        // System.out.println("CHANGE");
    }
    @FXML
    // private Button exit;
    public void logout(MouseEvent event){
        Alert a =new Alert(AlertType.CONFIRMATION);
        a.setTitle("Exit");
        a.setHeaderText("You are about to exit");
        a.setContentText("Are you sure you want to exit?");
        if(a.showAndWait().get()==ButtonType.OK){
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            System.out.println("logged out");
            stage.close();
        }
    }

    @FXML
    private TextField mytext;
    String name;
    public void userName(MouseEvent event){
        name=mytext.getText();
        Game g = new Game();
        Stage s = new Stage();
        g.draw();
        System.out.println("Hello "+name);
        System.out.println("Playing Game");
    }
    // @FXML
    // private Button load;
    public void loadgame(MouseEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/sample/load.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        // System.out.println("CHANGE");
    }

    @FXML
    // private Button back;
    public void backtoMM(MouseEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("/sample/mainmenu.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        // System.out.println("CHANGE");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    @FXML
    // private Button back;
    public void startGame(MouseEvent event) throws IOException {
        Game g = new Game();
        Stage s = new Stage();
//        g.draw();
         System.out.println("Playing Game");
    }
}

