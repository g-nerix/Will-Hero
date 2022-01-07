package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class Obstruction extends gameObject{
    private Image tnt;
    private Image explosion;
    private ImageView tntIV;
    private ImageView explosionIV;
    boolean isActive;
    boolean hasExploded;
    int timer = 0;

    Obstruction(coordinate c, AnchorPane p){
        setC(c);
        this.tnt = new Image("/sample/Obstruction/TNT.png");
        this.explosion = new Image("/sample/Obstruction/TNT_EXPLOSION.png");

        this.tntIV = new ImageView(tnt);
        this.explosionIV = new ImageView(explosion);

        tntIV.setFitWidth(30);
        tntIV.setFitHeight(40);
        tntIV.setX(c.getX());
        tntIV.setY(c.getY());

        explosionIV.setFitWidth(160);
        explosionIV.setX(c.getX()-50);
        explosionIV.setY(c.getY()-100);
        explosionIV.setPreserveRatio(true);
        explosionIV.setVisible(false);

        p.getChildren().add(explosionIV);
        p.getChildren().add(tntIV);

        coordinate b[] = new coordinate[4];
        b[0] = new coordinate(c.getX(),c.getY());
        b[1] = new coordinate(c.getX()+30,c.getY());
        b[2] = new coordinate(c.getX()+30,c.getY()+40);
        b[3] = new coordinate(c.getX(),c.getY()+40);
        setBoundary(b);

        isActive = false;
        hasExploded = false;
    }
    void explode(){
        explosionIV.setVisible(true);
        hasExploded = true;
    }
}
