package sample;

import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Weapon2 extends Weapon{
    RotateTransition attack;
    boolean isActive;
    int RotationCounter = 0;

    Weapon2(coordinate c, AnchorPane p){

        this.wp = new Image("/sample/Weapon/WeaponSword.png");
        this.iv = new ImageView(wp);
        iv.setX(c.getX());
        iv.setY(c.getY());
        iv.setPreserveRatio(true);
        iv.setFitHeight(40);
        p.getChildren().add(iv);
        isActive = true;
        setDamage(1);
    }

    @Override
    public void Upgrade() {
        setDamage(getDamage()+1);
    }
    public RotateTransition fire (){
        RotateTransition w2Rotate = new RotateTransition();
        w2Rotate.setDuration(Duration.millis(200));
        w2Rotate.setByAngle(360);
        w2Rotate.setNode(iv);
        w2Rotate.play();
        used = false;
        this.attack = w2Rotate;
        return w2Rotate;
    }
    
}
