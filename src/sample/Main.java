package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Menu m = new Menu();
        m.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
