package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Character extends gameObject{

    private TranslateTransition t;
    private ImageView i;
    private boolean fall;
    private int move =0;

    public boolean isFall() {
        return fall;
    }

    public void setFall(boolean fall) {
        this.fall = fall;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public TranslateTransition getT() {
        return t;
    }

    public void setT(TranslateTransition t) {
        this.t = t;
    }

    public ImageView getI() {
        return i;
    }

    public void setI(ImageView i) {
        this.i = i;
    }

    void show(AnchorPane p, coordinate c, String path, int size)
    {
        Image character_1 = new Image(path);
        ImageView imageview1 = new ImageView(character_1);
        imageview1.setX(c.getX());
        imageview1.setY(c.getY());
        imageview1.setPreserveRatio(true);
        imageview1.setFitWidth(size);

        TranslateTransition t = jump(imageview1,65,1);
        p.getChildren().add(t.getNode());
        this.i = imageview1;
        this.setC(c);
    }
    TranslateTransition jump(Node imageview1, int y, double rate) {
        TranslateTransition t = new TranslateTransition();
        t.setNode(imageview1);
        t.setCycleCount(TranslateTransition.INDEFINITE);    // temp change
        t.setDuration(Duration.millis(1000/rate));
        t.setByY(y);
        t.setAutoReverse(true);   // temp change
        t.play();
        this.t = t;
        return t;
    }
    TranslateTransition fall(Character c1){
        t.stop();
        this.t = t;
        return t;
    }

}

