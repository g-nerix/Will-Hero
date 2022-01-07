package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Weapon {
    int Damage;
    Image wp;
    ImageView iv;
    boolean used = false;

    protected void setDamage(int damage) {
        this.Damage = damage;
    }

    public int getDamage() {
        return this.Damage;
    }

    protected abstract void Upgrade() ;

    public void getWeapon(Character p){

    }

}
