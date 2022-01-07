package sample;

import java.io.Serializable;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    double AnnimationPaneLocation;
    int coin;
    int score;

    double c_GreenOrc[] = new double[15];
    boolean hasFallenGreen[] = new boolean[15];

    double c_RedOrc[] = new double[15];
    boolean hasFallenRed[] = new boolean[15];

    double c_BossOrc;
    boolean hasFallenBoss;

    double player_X;
    boolean hasFallenPlayer;

    boolean hasW1;
    boolean isActiveW1;
    int damageW1;

    boolean hasW2;
    boolean isActiveW2;
    int damageW2;
}
