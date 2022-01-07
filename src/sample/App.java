// package com.example.hellofx;
//package FX_Practice;



import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.util.Duration;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.*;


public class App extends Application {


    
    
    public boolean bool=true;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws IOException {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
            Scene scene=new Scene(root);
            primarystage.setScene(scene);
            primarystage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        


        
    }


}