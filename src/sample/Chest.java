package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Chest extends gameObject{
    private Image open;
    private Image close;
    private ImageView chestImageView;
    private boolean isOpen;

    public Image getOpen() {
        return open;
    }

    public void setOpen(Image open) {
        this.open = open;
    }

    public Image getClose() {
        return close;
    }

    public void setClose(Image close) {
        this.close = close;
    }

    public ImageView getChestImageView() {
        return chestImageView;
    }

    public void setChestImageView(ImageView chestImageView) {
        this.chestImageView = chestImageView;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    Chest(){
        this.open = new Image("/sample/Chest/ChestOpen.png");
        this.close = new Image("/sample/Chest/ChestClosed.png");

        this.chestImageView = new ImageView(close);
        this.chestImageView.setPreserveRatio(true);
        this.chestImageView.setFitWidth(50);
    }

    public abstract int getReward();

    void openReward(){
        this.chestImageView.setImage(this.open);
        this.chestImageView.setFitWidth(60);
    }

}
