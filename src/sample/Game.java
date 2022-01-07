package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game {
    private Stage stage;
    private Group root;
    private Scene scene;
    private Terrain t3;
    private AnimationTimer timer;
    private Player p;
    private AnchorPane p1;
    private Data gameData = new Data();
    private TranslateTransition t2;
    private boolean pause = false;

    private boolean over = false;
    private int coin = 0;
    private int AnimationTimerCounter = 0;
    private double playerX;
    private double playerY;
    private boolean isPause;
    private double AnimationPaneLocation;
    private ImageView wonIV;
    private boolean portalUsed = false;

    private double c_GreenOrc[] = new double[15];
    private boolean hasFallenGreen[] = new boolean[15];
    private double c_RedOrc[] = new double[15];
    private boolean hasFallenRed[] = new boolean[15];
    private double c_BossOrc;
    private boolean hasFallenBoss;

    public Stage getStage() {
        return stage;
    }

    public Group getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

    public Terrain getT3() {
        return t3;
    }

    public AnimationTimer getTimer() {
        return timer;
    }

    public Player getP() {
        return p;
    }

    public AnchorPane getP1() {
        return p1;
    }

    public Data getGameData() {
        return gameData;
    }

    public TranslateTransition getT2() {
        return t2;
    }

    public boolean isPause() {
        return pause;
    }

    public double getAnimationPaneLocation() {
        return AnimationPaneLocation;
    }

    public ImageView getWonIV() {
        return wonIV;
    }

    public double[] getC_GreenOrc() {
        return c_GreenOrc;
    }

    public boolean[] getHasFallenGreen() {
        return hasFallenGreen;
    }

    public double[] getC_RedOrc() {
        return c_RedOrc;
    }

    public boolean[] getHasFallenRed() {
        return hasFallenRed;
    }

    public double getC_BossOrc() {
        return c_BossOrc;
    }

    public boolean isHasFallenBoss() {
        return hasFallenBoss;
    }

    public boolean isOver() {
        return over;
    }

    public int getCoin() {
        return coin;
    }

    public int getAnimationTimerCounter() {
        return AnimationTimerCounter;
    }

    public double getPlayerX() {
        return playerX;
    }

    public double getPlayerY() {
        return playerY;
    }




 public void draw(){
     Button btn1 = new Button("forward");
     btn1.setOnAction(event -> {
         p1.setTranslateX(AnimationPaneLocation-200);
     });
     btn1.setLayoutX(500);
     btn1.setLayoutY(500);

     Button btn2 = new Button("Back");
     btn2.setOnAction(event -> {
         p1.setTranslateX(AnimationPaneLocation+200);
     });
     btn2.setLayoutX(450);
     btn2.setLayoutY(500);

     // Adding gradient to background
     Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.LIGHTSKYBLUE)};
     LinearGradient lg1 = new LinearGradient(0,1, 0, 0, true, CycleMethod.NO_CYCLE, stops);

     // Setting up initial stage, root node
     stage = new Stage();
     root = new Group();
     scene = new Scene(root, lg1);

     // Adding icon
     Image icon = new Image("/sample/icon.jpg");
     stage.getIcons().add(icon);
     p1 = new AnchorPane();
     root.getChildren().add(p1);

     // Adding Score

     Text score = new Text("Score");
     score.setText(""+0);
     score.setFont(new Font(20));
     score.setX(550);
     score.setY(30);
     score.setFill(Color.GOLD);
     score.setFont(new Font("Arial", 30));
     score.setWrappingWidth(200);
     root.getChildren().add(score);

     // Adding Pause
     Image pauseIcon = new Image("/sample/Images/GamePause.png");
     ImageView pauseIV = new ImageView(pauseIcon);
     pauseIV.setFitWidth(50);
     pauseIV.setPreserveRatio(true);
     root.getChildren().add(pauseIV);
     isPause = false;
     Image paused = new Image("/sample/Images/Pause.png");
     ImageView pausedIV = new ImageView(paused);
     pausedIV.setFitWidth(400);
     pausedIV.setPreserveRatio(true);
     pausedIV.setVisible(false);
     pausedIV.setX(400);

     root.getChildren().add(pausedIV);
     pauseIV.setOnMouseClicked(e ->{
         if(isPause){
             isPause = false;
         }
         else {
             isPause = true;
         }
         if (isPause){
             pausedIV.setVisible(true);
         }
         else{
             pausedIV.setVisible(false);
         }
     });

     // Adding won
     Image won = new Image("/sample/Images/Won.png");
     wonIV = new ImageView(won);
     wonIV.setX(400);
     wonIV.setFitWidth(400);
     wonIV.setPreserveRatio(true);
     wonIV.setVisible(false);
     root.getChildren().add(wonIV);

     // Adding options to revive
     Image revive = new Image("/sample/Images/Revive.png");
     ImageView reviveIV = new ImageView(revive);
     reviveIV.setFitWidth(400);
     reviveIV.setPreserveRatio(true);
     reviveIV.setVisible(false);
     reviveIV.setX(400);
     root.getChildren().add(reviveIV);

     reviveIV.setOnMouseClicked( e1-> {
         if(coin>=500){
             coin-=500;
             p.getI().setVisible(false);
             int tempX = p.getC().getX();
             if(p.hasWeapon1){
                 p.getW1().isActive = false;
                 p.getW1().iv.setVisible(false);
             }
             if(p.hasWeapon2){
                 p.w2.isActive = false;
                 p.w2.iv.setVisible(false);
             }
             this.p = new Player();
             this.p.show(p1);
             this.p.getHelmet().setX(playerX);
             p.setC(new coordinate((int)playerX,(int)p.getC().getY()));
         }
         reviveIV.setVisible(false);
     });

     root.getChildren().add(btn1);
     root.getChildren().add(btn2);

        // Adding Coin Counter
     Text coinCounter = new Text("Coin");
     coinCounter.setText(""+0);
     coinCounter.setFont(new Font(20));
     coinCounter.setX(1000);
     coinCounter.setY(30);
     coinCounter.setFill(Color.GOLD);
     coinCounter.setFont(new Font("Arial", 30));
     coinCounter.setWrappingWidth(200);
     root.getChildren().add(coinCounter);

     // Adding Coin Image next to coin counter
     //----- do something -------

     t3 = new Terrain(p1);

     // Handling Player
     p = new Player();
     p.show(p1);

     // Handling Save button
     Button btnSave = new Button("SAVE");
     btnSave.setOnAction(event -> {
         Data data = new Data();
         data.player_X = playerX;

         data.hasFallenPlayer = p.isFall();
         data.AnnimationPaneLocation = this.AnimationPaneLocation;
         data.hasW1 = p.hasWeapon1;
         if(p.hasWeapon1){
             data.isActiveW1 = p.getW1().isActive;
             data.damageW1 = p.getW1().getDamage();
         }

         data.hasW2 = p.hasWeapon2;
         if(p.hasWeapon2){
             data.isActiveW2 = p.w2.isActive;
             data.damageW2 = p.w2.getDamage();
         }

         data.c_GreenOrc = this.c_GreenOrc;
         data.hasFallenGreen = this.hasFallenGreen;
         data.c_RedOrc = this.c_RedOrc;
         data.hasFallenRed = this.hasFallenRed;

         data.c_BossOrc = this.c_BossOrc;
         data.hasFallenBoss = this.hasFallenBoss;

         data.coin = this.coin;
         data.score = Integer.parseInt(score.getText());
         System.out.println(data.score);
         // ORC data remaining...

         try {
             GameIO.save (data, "1.save");
         }
         catch (Exception e) {
             System.out.println("Couldn't save: " + e.getMessage());
         }
     });
     btnSave.setLayoutX(100);
    root.getChildren().add(btnSave);

    // Handling Load Button
     Button btnLoad = new Button ("LOAD");
     btnLoad.setOnAction (event -> {
         try {
             Data data = (Data) GameIO.load("1.save");

             p1.setTranslateX(data.AnnimationPaneLocation);
                p.getI().setVisible(false);
                p = new Player();
                p.show(p1);
                p.getHelmet().setX(data.player_X);
                p.getHelmet().setY(p.getC().getY());
                p.setC(new coordinate((int)data.player_X,p.getC().getY()));

                playerX = data.player_X;
                playerY = p.getC().getY();

                p.setFall(data.hasFallenPlayer);

                if(data.hasW1){
                    p.hasWeapon1 = data.hasW1;
                    p.setW1(new Weapon1(new coordinate((int) playerX, (int) playerY), p1));
                    p.getW1().isActive = data.isActiveW1;
                    p.getW1().setDamage(data.damageW1);
                }
             if(data.hasW2){
                 p.hasWeapon2 = data.hasW2;
                 p.w2 = new Weapon2(new coordinate((int) playerX, (int) playerY), p1);
                 p.w2.isActive = data.isActiveW2;
                 p.w2.setDamage(data.damageW2);
             }
             for(int i = 0; i < 15; i++){
                 t3.getTerrain_greenOrc().get(i).setFall(data.hasFallenGreen[i]);
                 t3.getTerrain_greenOrc().get(i).getI().setX(data.c_GreenOrc[i]);

                 t3.getTerrain_redOrc().get(i).setFall(data.hasFallenRed[i]);
                 t3.getTerrain_redOrc().get(i).getI().setX(data.c_RedOrc[i]);
             }
             t3.getBoss().setFall(data.hasFallenBoss);
             t3.getBoss().getI().setX(data.c_BossOrc);

             score.setText(String.valueOf(data.score));
             coin = data.coin;
         }
         catch (Exception e) {
             System.out.println("Couldn't load save data: " + e.getMessage());
         }
     });
     btnLoad.setLayoutX(200);
     root.getChildren().add(btnLoad);

     scene.setOnKeyPressed(e -> {
         // Managing Weapon change
         if (e.getCode() == KeyCode.S){
             if(!isPause){
                 System.out.println("TAB key was pressed");
                 if(p.hasWeapon2&&p.hasWeapon1){
                     if(p.getW1().isActive){
                         p.getW1().isActive = false;
                         p.getW1().iv.setVisible(false);
                         p.w2.iv.setVisible(true);
                         p.w2.isActive = true;
                     }
                     else{
                         p.w2.isActive = false;
                         p.w2.iv.setVisible(false);
                         p.getW1().iv.setVisible(true);
                         p.getW1().isActive = true;
                     }
                 }
             }
         }

         // Managing Movement of Player
         if (e.getCode() == KeyCode.A) {
             System.out.println("SPACE key was pressed");
             if(!p.isFall()) {
                 // Translating window pane
                 t2 = new TranslateTransition();
                 t2.setNode(p1);
                 t2.setByX(-75);
                 t2.setDuration(Duration.millis(200));
                 if (!p.isFall() && !isPause) {
                     t2.play();
                 }

                 // translating main character
                 TranslateTransition t4 = new TranslateTransition();
                 t4.setNode(p.getHelmet());
                 t4.setByX(75);
                 t4.setDuration(Duration.millis(150));
                 if(!isPause){
                     t4.play();
                     score.setText("" + (Integer.parseInt(score.getText()) + 5));
                     coinCounter.setText("" + coin);
                 }


             }
         }
     });
     stage.setScene(scene);
     stage.setTitle("Will Hero");
     stage.setHeight(600);
     stage.setWidth(1200);
     stage.setResizable(false);

     timer = new AnimationTimer() {
         @Override
         public void handle(long now) {
             AnimationPaneLocation = p1.getTranslateX();

             // Setting Boundary of Player
             coordinate b[] = new coordinate[4];
             b[0] = new coordinate((int)(p.getHelmet().getX()+p.getHelmet().getTranslateX())+10,(int)(p.getHelmet().getY()+p.getHelmet().getTranslateY())+10);
             b[1] = new coordinate((int)(p.getHelmet().getX()+p.getHelmet().getTranslateX())+40,(int)(p.getHelmet().getY()+p.getHelmet().getTranslateY())+10);
             b[2] = new coordinate((int)(p.getHelmet().getX()+p.getHelmet().getTranslateX())+40,(int)(p.getHelmet().getY()+p.getHelmet().getTranslateY()+50));
             b[3] = new coordinate((int)(p.getHelmet().getX()+p.getHelmet().getTranslateX())+10,(int)(p.getHelmet().getY()+p.getHelmet().getTranslateY()+50));
             p.setBoundary(b);

             // Collision with the island
             if (p.getBoundary()[2].getY()>=t3.getTerrain_island().get(0).getBoundary()[0].y){
                 for(int i = 0; i < t3.getTerrain_island().size()-1;i++){
                     if(t3.getTerrain_island().get(i).getBoundary()[1].getX()<p.getBoundary()[0].getX() && t3.getTerrain_island().get(i+1).getBoundary()[0].getX()>p.getBoundary()[1].getX()){
                         System.out.println("Fall");
                         p.getT().stop();
                         p.setFall(true);
//                         over = true;
                     }
                 }
             }
             if (p.isFall()){
                 if(p.getMove() < 50){
                     p.getHelmet().setY(p.getHelmet().getY()*1.02);
                 }
                 else{
                     p.setMove(0);
                 }

             }

             double WeaponX = 0;
             double WeaponY = 0;

             for(int k = 0; k<t3.getTerrain_greenOrc().size();k++) {

                greenOrc g = t3.getTerrain_greenOrc().get(k);
                redOrc r = t3.getTerrain_redOrc().get(k);

                // Setting Coordinates for Weapon 1
                if(p.hasWeapon1){
                    WeaponX = p.getW1().iv.getX()+p.getW1().iv.getTranslateX();
                    WeaponY = p.getW1().iv.getY()+p.getW1().iv.getTranslateY();
                }

                 // Setting Coordinates for Weapon 2
                 if(p.hasWeapon2){
                     WeaponX = p.w2.iv.getX()+p.w2.iv.getTranslateX();
                     WeaponY = p.w2.iv.getY()+p.w2.iv.getTranslateY();
                 }

                double orcX = 0;
                double orcY = 0;
                 orcX = g.getC().getX();
                 orcY = g.getC().getY() + g.getI().getTranslateY();

                double orcRX = 0;
                double orcRY = 0;
                 orcRX = r.getC().getX();
                 orcRY = r.getC().getY() + r.getI().getTranslateY();

                // For Loading and Saving ORC data
                c_GreenOrc[k] = orcX;
                hasFallenGreen[k] = g.isFall();
                c_RedOrc[k] = orcRX;
                hasFallenRed[k] = r.isFall();

                playerX = p.getC().getX() + p.getI().getTranslateX();
                playerY = p.getC().getY() + p.getI().getTranslateY();

//                System.out.println("player x:" + playerX);
//                System.out.println("player y:" + playerY);

                if(!g.isFall()){
                    // Killed by orc
                    if (playerX + 10 <= orcX + 40 && playerX + 40 >= orcX + 0){
                        if (playerY+10 - orcY - 30 <= 0 ){
                            if(playerY+10 - orcY - 30 >= -2){
                                p.setFall(true);
                            }
                        }
                    }
                    // Pushed orc
                    if (playerX + 40  > orcX && playerX + 10  < orcX) {
                        if(playerY+10 <= orcY+40 && playerY+40 >orcY) {

                            // Struck by Weapon 1
                            if(p.hasWeapon1){
                                p.getW1().used = true;
                                g.setFall(true);
                            }

                            // Struck by Weapon 2
                            if(p.hasWeapon2){
                                p.w2.used = true;
                                g.setFall(true);
                            }

                            // pushing
                            System.out.println(playerX + 55 + " touch " + orcX);
                            g.getI().setX(g.getI().getX() + 13);
                            g.getC().setX((int) (orcX + 13));
                        }

                    }
                }

                // RED ORC
                if(!r.isFall()){
                    // Killed by orc
                    if (playerX + 10 <= orcRX + 40 && playerX + 40 >= orcRX + 0){
                        if (playerY+10 - orcRY - 30 <= 0 ){
                            if(playerY+10 - orcRY - 30 >= -2){
                                p.setFall(true);
                            }
                        }
                    }
                    // Pushed orc
                    if (playerX + 40 - 2 > orcRX && playerX + 10 -2 < orcRX) {
                        if(playerY + 10 <= orcRY + 40 && playerY + 40 > orcRY) {

                            // Struck by Weapon 1
                            if(p.hasWeapon1){
                                p.getW1().used = true;
                                r.setFall(true);
                            }

                            // Struck by Weapon 2
                            if(p.hasWeapon2){
                                p.w2.used = true;
                                r.setFall(true);
                            }

                            // Pushed Red Orc
                            System.out.println(playerX + 55 + " touch " + orcRX);
                            r.getI().setX(r.getI().getX() + 13);
                            r.getC().setX((int)(orcRX + 13));
                        }
                    }
                }

                for (int i = 0; i < t3.getTerrain_island().size() - 1; i++) {
                    // GREEN ORC
                    if (t3.getTerrain_island().get(i).getBoundary()[1].getX() < orcX && t3.getTerrain_island().get(i + 1).getBoundary()[0].getX() > orcX+40) {
                        if (g.getI().getTranslateY() > 60) {
                            System.out.println("orc Fall");
                            g.getT().stop();
                            g.setFall(true);
                        }
                    }
                    // RED ORC
                    if (t3.getTerrain_island().get(i).getBoundary()[1].getX() < orcRX && t3.getTerrain_island().get(i + 1).getBoundary()[0].getX() > orcRX+40) {
                        if (r.getI().getTranslateY() > 60) {
                            System.out.println("orc Fall");
                            r.getT().stop();
                            r.setFall(true);
                        }
                    }
                }
                if (g.isFall()) {
                    g.getI().setY(g.getI().getY() + 3);
                }
                if (r.isFall()) {
                    r.getI().setY(r.getI().getY() + 3);
                }
            }

             playerX = p.getC().getX() + p.getI().getTranslateX();
             playerY = p.getC().getY() + p.getI().getTranslateY();

             // Coin Chest
            for (int i = 0;i<t3.getTerrain_coinChest().size();i++){

                coinChest cc = t3.getTerrain_coinChest().get(i);
                weaponChest wc = t3.getTerrain_weaponChest().get(i);

                // Coin Chest
                if(!cc.isOpen()){
                    if(playerX+40 > cc.getBoundary()[0].getX() && playerX+10<cc.getBoundary()[1].getX()){
                        if(playerY + 50 < cc.getBoundary()[3].getY() && playerY + 50 >cc.getBoundary()[0].getY()){
                            coin += cc.getReward();
                            cc.setOpen(true);
                        }
                    }
                }

                // Weapon Chest
                if(!wc.isOpen()){
                    if(playerX+40 > wc.getBoundary()[0].getX() && playerX+10<wc.getBoundary()[1].getX()){
                        if(playerY + 50 < wc.getBoundary()[3].getY() && playerY + 50 > wc.getBoundary()[0].getY()){
                            wc.setOpen(true);

                            if (Math.random()>0.5) {
                                // Adding Weapon1
                                if(p.hasWeapon2){
                                    p.w2.iv.setVisible(false);
                                    p.w2.isActive = false;
                                }
                                if (!p.hasWeapon1) {
                                    Weapon1 w = new Weapon1(new coordinate((int) playerX, (int) playerY), p1);
                                    p.setW1(w);
                                    p.hasWeapon1 = true;
                                }
                                else {
                                    p.getW1().iv.setVisible(true);
                                    p.getW1().Upgrade();
                                }

                            }
                            else{
                                // Adding Weapon2
                                if(p.hasWeapon1){
                                    p.getW1().iv.setVisible(false);
                                    p.getW1().isActive = false;
                                }
                                if(!p.hasWeapon2){
                                    Weapon2 w = new Weapon2(new coordinate((int)playerX,(int)playerY),p1);
                                    p.w2 = w;
                                    p.hasWeapon2 = true;
                                }
                                else{
                                    p.w2.iv.setVisible(true);
                                    p.w2.Upgrade();
                                }
                            }

                        }
                    }
                }
                if(p.hasWeapon1){
                    p.getW1().iv.setY(playerY);
                    p.getW1().iv.setX(playerX);
                }

                if(p.hasWeapon2){
                    p.w2.iv.setY(playerY);
                    p.w2.iv.setX(playerX);
                }

            }
//              managing TNT

             if(!t3.getTNT().hasExploded && !t3.getTNT().isActive){
                 if(playerX > t3.getTNT().getC().getX()-50){
                     if(playerX < t3.getTNT().getC().getX()+50){
                         t3.getTNT().isActive = true;
                     }
                 }
             }

             if(t3.getTNT().isActive){
                 if(t3.getTNT().timer<100){
                     t3.getTNT().timer++;
                 }
                 else{
                     t3.getTNT().explode();
                     t3.getTNT().hasExploded = true;
                     t3.getTNT().isActive = false;
                     if(playerX > t3.getTNT().getC().getX()-100 && playerX < t3.getTNT().getC().getX()+100){
                         p.fall(p);
                         p.setFall(true);
                     }
                 }
             }

             if(p.hasWeapon1){
                 // rotating weapon2
                 if(p.getW1().used){
                     RotateTransition w1Rotate = p.getW1().fire();
                 }
             }

            if(p.hasWeapon2){
                 // rotating weapon2
                 if(p.w2.used){
                     RotateTransition w2Rotate = p.w2.fire();
                     }
             }

            // collision with boss
             BossOrc boss = t3.getBoss();
             double bossX = boss.getC().getX();
             double bossY = boss.getC().getY() + boss.getI().getTranslateY();

             // Load and Save Boss
             c_BossOrc = bossX;
             hasFallenBoss = boss.isFall();

             // pushed boss
             if(!boss.isFall()){
                 if(playerX+40 > bossX && playerX+10 < bossX + 140){
                     if(playerY+40>bossY && playerY<bossY+140){
                         boss.getI().setX(boss.getI().getX() + 13);
                         boss.getC().setX((int) (bossX + 13));

                         // Struck by Weapon 1
                         if(p.hasWeapon1){
                             p.getW1().used = true;
                             boss.setHealth(boss.getHealth()-p.getW1().getDamage());
                         }

                         // Struck by Weapon 2
                         if(p.hasWeapon2){
                             p.w2.used = true;
                             boss.setHealth(boss.getHealth()-p.w2.getDamage());
                         }
                     }
                 }
                 // killed by Boss
                 if (playerX + 10 <= bossX + 140 && playerX + 40 >= bossX + 0){
                     if (playerY+10 - bossY - 30 <= 0 ){
                         if(playerY+10 - bossY - 30 >= -2){
                             p.setFall(true);
                         }
                     }
                 }
             }

            if(boss.getHealth()<0){
                boss.setFall(true);
                isPause = true;
                wonIV.setVisible(true);
            }
             if (boss.isFall()) {
                 boss.getI().setY(boss.getI().getY() + 6);
             }

             // Portal thingy...
//             if(!portalUsed){
//                 if(playerX+40 >2200 && playerX+10 < 2260){
//                     if(playerY < 310 && playerY+40 > 250){
//                         portalUsed =true;
//                         p.getI().setX(playerX+100);
//                    p1.setTranslateX(100);
////                         t2.setByX(100);
//                         p.getI().setTranslateX(-100);
//
//
//                     }
//                 }
//             }


             // Exiting Animation Timer
             if(p.isFall()){
                 AnimationTimerCounter ++;
                 if(AnimationTimerCounter>100){
                     System.out.println("Player has fallen.");
                     reviveIV.setVisible(true);
                     System.out.println("Exiting Animation Timer...");
//                     timer.stop();
                 }
             }
         }
     };
     timer.start();
     stage.show();
    }
}
