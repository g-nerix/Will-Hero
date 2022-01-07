package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Terrain {

    private ArrayList <Island> terrain_island;
    private ArrayList <redOrc> terrain_redOrc;
    private ArrayList <greenOrc> terrain_greenOrc;
    private ArrayList <Coin> terrain_coin;
    private ArrayList <weaponChest> terrain_weaponChest;
    private ArrayList <coinChest> terrain_coinChest;
    private Obstruction TNT;
    private BossOrc boss;

    public Obstruction getTNT() {
        return TNT;
    }

    public void setTNT(Obstruction TNT) {
        this.TNT = TNT;
    }

    public BossOrc getBoss() {
        return boss;
    }

    public void setBoss(BossOrc boss) {
        this.boss = boss;
    }

    Terrain(AnchorPane p){
        this.terrain_island  = new ArrayList<Island>();
        this.terrain_redOrc  = new ArrayList<redOrc>();
        this.terrain_greenOrc  = new ArrayList<greenOrc>();
        this.terrain_coin  = new ArrayList<Coin>();
        this.terrain_weaponChest  = new ArrayList<weaponChest>();
        this.terrain_coinChest = new ArrayList<coinChest>();

        drawIsland(p);
        drawBossOrc(p);
        drawRedOrc(p);
        drawGreenOrc(p);
        drawCoinChest(p);
        drawWeaponChest(p);
        drawObstruction(p);

        Image portal = new Image("/sample/Images/portal.png");
        ImageView portalIV = new ImageView(portal);
        portalIV.setX(2200);
        portalIV.setY(250);
        portalIV.setFitWidth(60);
        portalIV.setPreserveRatio(true);
        p.getChildren().add(portalIV);

    }

    public ArrayList<Island> getTerrain_island() {
        return terrain_island;
    }

    public void setTerrain_island(ArrayList<Island> terrain_island) {
        this.terrain_island = terrain_island;
    }

    public ArrayList<redOrc> getTerrain_redOrc() {
        return terrain_redOrc;
    }

    public void setTerrain_redOrc(ArrayList<redOrc> terrain_redOrc) {
        this.terrain_redOrc = terrain_redOrc;
    }

    public ArrayList<greenOrc> getTerrain_greenOrc() {
        return terrain_greenOrc;
    }

    public void setTerrain_greenOrc(ArrayList<greenOrc> terrain_greenOrc) {
        this.terrain_greenOrc = terrain_greenOrc;
    }

    public ArrayList<Coin> getTerrain_coin() {
        return terrain_coin;
    }

    public void setTerrain_coin(ArrayList<Coin> terrain_coin) {
        this.terrain_coin = terrain_coin;
    }

    public ArrayList<weaponChest> getTerrain_weaponChest() {
        return terrain_weaponChest;
    }

    public void setTerrain_weaponChest(ArrayList<weaponChest> terrain_weaponChest) {
        this.terrain_weaponChest = terrain_weaponChest;
    }

    public ArrayList<coinChest> getTerrain_coinChest() {
        return terrain_coinChest;
    }

    public void setTerrain_coinChest(ArrayList<coinChest> terrain_coinChest) {
        this.terrain_coinChest = terrain_coinChest;
    }

    public void drawTerrain(){

    }
    public void drawIsland(AnchorPane p){
//        terrain_island.add(new Island(new coordinate(10,20),1,p));
        coordinate c[] = {
                new coordinate(34   ,200),  // # 1
                new coordinate(328  ,200),  // # 2
                new coordinate(489  ,200),  // # 3
                new coordinate(762  ,200),  // # 4
                new coordinate(1063 ,200),  // # 5
                new coordinate(1371 ,200),  // # 6
                new coordinate(1548 ,200),  // # 7
                new coordinate(1728 ,200),  // # 8
                new coordinate(1927 ,200),  // # 9
                new coordinate(2241 ,200),  // # 10
                new coordinate(2512 ,200),  // # 11
                new coordinate(2831 ,200),  // # 12
                new coordinate(3142 ,200),  // # 13
                new coordinate(3416 ,200),  // # 14
                new coordinate(3708 ,200),  // # 15
                new coordinate(4027 ,200),  // # 16
                new coordinate(4214 ,200),  // # 17
                new coordinate(4518 ,200),  // # 18
                new coordinate(4680 ,200),  // # 19
                new coordinate(4875 ,200),  // # 20
                new coordinate(5073 ,200),  // # 21
                new coordinate(5278 ,200),  // # 22
                new coordinate(5554 ,200),  // # 23
                new coordinate(5868 ,200),  // # 24
                new coordinate(6067 ,200),  // # 25
                new coordinate(6358 ,200),  // # 26
                new coordinate(6665 ,200),  // # 27
                new coordinate(6959 ,200),  // # 28
                new coordinate(7121 ,200),  // # 29
                new coordinate(7315 ,200),  // # 30
                new coordinate(7606 ,200),  // # 31
                new coordinate(7777 ,200),  // # 32
                new coordinate(7963 ,200),  // # 33
                new coordinate(8136 ,200),  // # 34
                new coordinate(8437 ,200),  // # 35
                new coordinate(8646 ,200),  // # 36
                new coordinate(8844 ,200),  // # 37
                new coordinate(9041 ,200),  // # 38
                new coordinate(9341 ,200),  // # 39
                new coordinate(9650 ,200),  // # 40
                new coordinate(9927 ,200),  // # 41
                new coordinate(10131,200),  // # 42
                new coordinate(10297,200),  // # 43
                new coordinate(10588,200),  // # 44
                new coordinate(10761,200),  // # 45
                new coordinate(11058,200),  // # 46
                new coordinate(11373,200),  // # 47
                new coordinate(11541,200),  // # 48
                new coordinate(11826,200),  // # 49
                new coordinate(11988,200),  // # 50
                new coordinate(12150,200),  // # 51
                new coordinate(12322,200),  // # 52
                new coordinate(12498,200),  // # 53
                new coordinate(12654,200),  // # 54
                new coordinate(12825,200),  // # 55
                new coordinate(13127,200),  // # 56
                new coordinate(13417,200),  // # 57
                new coordinate(13603,200),  // # 58
                new coordinate(13893,200),  // # 59
                new coordinate(14067,200),  // # 60
                new coordinate(14246,200),  // # 61
                new coordinate(14521,200),  // # 62
                new coordinate(14702,200),  // # 63
                new coordinate(14976,200),  // # 64
                new coordinate(15175,200),  // # 65
                new coordinate(15363,200),  // # 66
                new coordinate(15563,200),  // # 67
                new coordinate(15877,200),  // # 68
                new coordinate(16071,200),  // # 69
                new coordinate(16345,200),  // # 70
                new coordinate(16524,200),  // # 71
                new coordinate(16829,200),  // # 72
                new coordinate(17138,200),  // # 73
                new coordinate(17338,200),  // # 74
                new coordinate(17534,200),  // # 75
                new coordinate(17709,200),  // # 76
                new coordinate(17896,200),  // # 77
                new coordinate(18075,200),  // # 78
                new coordinate(18225,200),  // # 79
                new coordinate(18401,200),  // # 80
                new coordinate(18706,200),  // # 81
                new coordinate(18878,200),  // # 82
                new coordinate(19150,200),  // # 83
                new coordinate(19435,200),  // # 84
                new coordinate(19601,200),  // # 85
                new coordinate(19773,200),  // # 86
                new coordinate(20074,200),  // # 87
                new coordinate(20252,200),  // # 88
                new coordinate(20421,200),  // # 89
                new coordinate(20584,200),  // # 90
                new coordinate(20760,200),  // # 91
                new coordinate(20939,200),  // # 92
                new coordinate(21254,200),  // # 93
                new coordinate(21531,200),  // # 94
                new coordinate(21681,200),  // # 95
                new coordinate(21842,200),  // # 96
                new coordinate(22018,200),  // # 97
                new coordinate(22225,200),  // # 98
                new coordinate(22405,200),  // # 99
                new coordinate(22566,200),  // # 100
                new coordinate(22726,200),  // # 101
                new coordinate(23031,200),  // # 102
                new coordinate(23229,200),  // # 103
                new coordinate(23411,200),  // # 104
                new coordinate(23704,200),  // # 105
                new coordinate(23997,200),  // # 106
                new coordinate(24160,200),  // # 107
                new coordinate(24361,200),  // # 108
                new coordinate(24675,200),  // # 109
                new coordinate(24991,200),  // # 110
                new coordinate(25182,200),  // # 111
                new coordinate(25457,200),  // # 112
                new coordinate(25619,200),  // # 113
                new coordinate(25804,200),  // # 114
                new coordinate(26116,200),  // # 115
                new coordinate(26267,200),  // # 116
                new coordinate(26461,200),  // # 117
                new coordinate(26621,200),  // # 118
                new coordinate(26798,200),  // # 119
                new coordinate(27100,200),  // # 120
                new coordinate(27266,200),  // # 121
                new coordinate(27559,200),  // # 122

        };
        int type[] = {
                3,1,3,3,3,1,2,1,3,3,        // 10
                3,3,3,3,3,1,3,2,1,2,        // 20
                2,3,3,1,3,3,3,1,1,3,        // 30
                2,2,2,3,2,1,1,3,3,3,        // 40
                2,1,3,2,3,3,2,3,2,2,        // 50
                2,2,1,1,3,3,2,3,1,1,        // 60
                3,2,3,1,1,2,3,2,3,1,        // 70
                3,3,2,1,2,2,1,1,2,3,        // 80
                2,3,3,2,2,3,1,2,1,2,        // 90
                1,3,3,1,1,2,2,2,1,1,        // 100
                3,1,1,3,3,1,2,3,3,2,        // 120
                3,2,2,3,1,2,2,2,3,2,        // 120
                3,3};                       // 122

        for (int i = 0; i < 122; i++){
            c[i].x+=10*i;
        }

        for (int i = 0; i < 122; i++){
            terrain_island.add(new Island(c[i],type[i],p));
        }
    }
    public void drawRedOrc(AnchorPane p){
        coordinate c_Red[]={
                new coordinate(1120 ,200),  // # 3
                new coordinate(1630 ,200),  // # 4
                new coordinate(2090 ,200),  // # 5 '''
                new coordinate(2987 ,200),  // # 7
                new coordinate(3583 ,200),  // # 9
                new coordinate(4210 ,200),  // # 11
                new coordinate(4534 ,200),  // # 13
                new coordinate(5070,200),  // # 15
                new coordinate(5580,200),  // # 17
                new coordinate(6152,200),  // # 19
                new coordinate(6739,200),  // # 21
                new coordinate(7492,200),  // # 23
                new coordinate(8117,200),  // # 25
                new coordinate(8626,200),  // # 27
                new coordinate(9476,200)   // # 29
        };

        for (int i = 0; i < 15; i++){
            redOrc o = new redOrc(c_Red[i]);
            o.show(p, new coordinate(c_Red[i].getX(),c_Red[i].getY()-20),"/sample/Orcs/Red/RedOrcBoss.png",40);
            terrain_redOrc.add(o);
        }
    }
    public void drawGreenOrc(AnchorPane p){
        coordinate c_Green[]={
                new coordinate(170  ,200),  // # 1
                new coordinate(950  ,200),  // # 2
                new coordinate(2633 ,200),  // # 6
                new coordinate(3287 ,200),  // # 8
                new coordinate(3891 ,200),   // # 10
                new coordinate(4382 ,200),  // # 12
                new coordinate(4716,200),  // # 14
                new coordinate(5376,200),  // # 16
                new coordinate(5828,200),  // # 18
                new coordinate(6362,200),  // # 20
                new coordinate(7114,200),  // # 22
                new coordinate(7744,200),  // # 24
                new coordinate(8307,200),  // # 26
                new coordinate(9008,200),  // # 28
                new coordinate(9608,200)   // # 30
        };

        for (int i = 0; i < 15; i++){

            greenOrc o = new greenOrc(c_Green[i]);
            o.show(p, new coordinate(c_Green[i].getX(),c_Green[i].getY()-20),"/sample/Orcs/Green/Orc1.png",40);
            terrain_greenOrc.add(o);
        }
    }
    public void drawCoinChest(AnchorPane p){
        coordinate c_CoinChest[]={
                new coordinate(550  ,255),  // #2
                new coordinate(1200 ,255),  // #3
                new coordinate(3000 ,255),  // #5
                new coordinate(4950 ,255),  // #7
                new coordinate(7050 ,255),  // #9
        };
        for(int i = 0; i < c_CoinChest.length; i++){
            terrain_coinChest.add(new coinChest(c_CoinChest[i],p));
        }
    }

    public void drawWeaponChest(AnchorPane p){
        coordinate c_WeaponChest[]={
                new coordinate(350  ,255),  // #1
                new coordinate(2050 ,255),  // #4
                new coordinate(4000 ,255),  // #6
                new coordinate(5950 ,255),  // #8
                new coordinate(8000,255),  // #10
        };
        for(int i = 0; i < c_WeaponChest.length; i++){
            terrain_weaponChest.add(new weaponChest(c_WeaponChest[i],p));
        }
    }
    public void drawObstruction(AnchorPane p){
        coordinate c = new coordinate(1450,250);
        TNT = new Obstruction(c,p);
    }
    public void drawBossOrc(AnchorPane p){
        coordinate c = new coordinate(10100,100);
        BossOrc o = new BossOrc(c);
        o.show(p, c,"/sample/Orcs/Green/Orc1.png",140);
        this.boss = o;

        coordinate b[] = new coordinate[4];
                 b[0] = new coordinate(c.getX(),c.getY());
                 b[1] = new coordinate(c.getX()+140,c.getY());
                 b[2] = new coordinate(c.getX()+140,c.getY()+130);
                 b[3] = new coordinate(c.getX(),c.getY()+130);
                 o.setBoundary(b);

    }

}