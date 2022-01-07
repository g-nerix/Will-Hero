package sample;

public class Orcs extends Character {
    private int health;
    private int size;

    protected void setHealth(int health) {
        this.health = health;

    }

    public int getHealth() {
        return this.health;
    }

    protected void setSize(int size) {
        this.size = size;

    }

    public int getSize() {
        return this.size;
    }

}
