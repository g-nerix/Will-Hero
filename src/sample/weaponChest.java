package sample;

import javafx.scene.layout.AnchorPane;

public class weaponChest extends Chest{
    weaponChest(coordinate c, AnchorPane p){
        setC(c);
        this.getChestImageView().setX(c.getX());
        this.getChestImageView().setY(c.getY());

        p.getChildren().add(getChestImageView());

        coordinate b[] = new coordinate[4];

        b[0] = new coordinate(c.getX()+0,(int)(c.getY()+0));
        b[1] = new coordinate(c.getX()+50,(int)(c.getY()+0));
        b[2] = new coordinate(c.getX()+50,(int)(c.getY()+35));
        b[3] = new coordinate(c.getX()+0,(int)(c.getY()+35));
        setBoundary(b);
    }
    Weapon w = new Weapon() {
        @Override
        protected void Upgrade() {

        }
    };
    public int getReward() {
        openReward();
        return 0;
    }

    
}
