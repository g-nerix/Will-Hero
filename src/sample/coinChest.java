package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class coinChest extends Chest {
    int coin;

    coinChest(coordinate c, AnchorPane p){
        setC(c);
        this.getChestImageView().setX(c.getX());
        this.getChestImageView().setY(c.getY());
        this.coin = 500;
        p.getChildren().add(getChestImageView());

        coordinate b[] = new coordinate[4];

        b[0] = new coordinate(c.getX()+0,(int)(c.getY()+0));
        b[1] = new coordinate(c.getX()+50,(int)(c.getY()+0));
        b[2] = new coordinate(c.getX()+50,(int)(c.getY()+35));
        b[3] = new coordinate(c.getX()+0,(int)(c.getY()+35));
        setBoundary(b);

    }

    public int getReward() {
        openReward();
        return coin;
    }

}
