package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Player extends Character{
    private TranslateTransition t;
    private ImageView helmet;

    public Weapon1 getW1() {
        return w1;
    }

    public void setW1(Weapon1 w1) {
        this.w1 = w1;
    }

    private Weapon1 w1;
    Weapon2 w2;
    boolean hasWeapon1 = false;
    boolean hasWeapon2 = false;

    public ImageView getHelmet() {
        return helmet;
    }

    public void setHelmet(ImageView helmet) {
        this.helmet = helmet;
    }

    void show(AnchorPane p)
    {

        setC(new coordinate(100,200));
        Image helmet1 = new Image("/sample/Helmet/helmet_1.png");
        ImageView imageview1 = new ImageView(helmet1);
        imageview1.setX(getC().getX());
        imageview1.setY(getC().getY());

        imageview1.setPreserveRatio(true);
        imageview1.setFitWidth(50);
        this.helmet = imageview1;
        this.setI(imageview1);

        TranslateTransition t = jump(imageview1,43,1.7);
        p.getChildren().add(t.getNode());

        // Boundary line:
        coordinate b[] = new coordinate[4];
        b[0] = new coordinate((int)(helmet.getX()+helmet.getTranslateX()),(int)(helmet.getY()+helmet.getTranslateY()));
        b[1] = new coordinate((int)(helmet.getX()+helmet.getTranslateX()),(int)(helmet.getY()+helmet.getTranslateY()));
        b[2] = new coordinate((int)(helmet.getX()+helmet.getTranslateX()),(int)(helmet.getY()+helmet.getTranslateY()));
        b[3] = new coordinate((int)(helmet.getX()+helmet.getTranslateX()),(int)(helmet.getY()+helmet.getTranslateY()));
        setBoundary(b);

    }

}
