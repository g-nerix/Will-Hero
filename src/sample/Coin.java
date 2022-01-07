package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Coin extends gameObject{
    ImageView coin;
    Coin(coordinate c, AnchorPane p){
        this.setC(c);
        Image coin = new Image("/sample/Coin/coin.png");
        ImageView imageview1 = new ImageView(coin);
        imageview1.setX(c.getX());
        imageview1.setY(c.getY());
//        imageview1.setY(i.islandCoordinates.get(0)[1].getY()-60);
        imageview1.setPreserveRatio(true);
        imageview1.setFitWidth(10);
        this.coin = imageview1;
        p.getChildren().add(this.coin);
    }
}
