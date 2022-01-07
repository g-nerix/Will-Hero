package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Island extends gameObject{
    private ImageView islandImage;

    Island(@NotNull coordinate c, int n, AnchorPane p)
    {
        int scale = 0;
        this.setC(new coordinate(c.getX(),c.getY()));
        coordinate b[] = new coordinate[4];
        switch (n){
            case 1:
                scale = 150;
                c.setY(230);

                b[0] = new coordinate(c.getX()+10,(int)(200+90));
                b[1] = new coordinate(c.getX()+scale-5,(int)(200+90));
                b[2] = new coordinate(c.getX()+scale-5,(int)(200+180));
                b[3] = new coordinate(c.getX()+10,(int)(200+180));
                setBoundary(b);
                break;
            case 2:
                scale = 160;
                c.setY(270);

                b[0] = new coordinate(c.getX()+5,(int)(200+90));
                b[1] = new coordinate(c.getX()+scale,(int)(200+90));
                b[2] = new coordinate(c.getX()+scale,(int)(200+135));
                b[3] = new coordinate(c.getX()+5,(int)(200+135));
                setBoundary(b);
                break;
            case 3:
                scale = 270;

                b[0] = new coordinate(c.getX()+15,(int)(200+90));
                b[1] = new coordinate(c.getX()+scale-15,(int)(200+90));
                b[2] = new coordinate(c.getX()+scale-15,(int)(200+160));
                b[3] = new coordinate(c.getX()+15,(int)(200+160));
                setBoundary(b);
                break;
            default:
                // code block
        }

        this.islandImage = addIsland(n,c.getX(),c.getY(),scale,p);


    }
    public ImageView getIslandImage() {
        return islandImage;
    }

    public void setIslandImage(ImageView islandImage) {
        this.islandImage = islandImage;
    }

    private coordinate c;

    static ArrayList<ImageView> islandLists = new ArrayList<>();
    static ArrayList<coordinate[]> islandCoordinates = new ArrayList<>();

    void drawIsland(int n, Group root){
        Random r = new Random();
        int x = 10;
        int y = 200;
        int scale = 0;
        for (int j = 0; j < n; j++){
            int i = 1 + r.nextInt(3);
            x += scale + r.nextInt(50);
            y = 200 + r.nextInt(5);
            System.out.println("-------------------------------------------");
            System.out.println("Draw..."+(j+1)+" Island "+i+"\tx = "+x+"  \t\ty = "+y);

            switch (i){
                case 1:
                    scale = 150;
                    y = 220+r.nextInt(10);
                    break;
                case 2:
                    scale = 160;
                    y = 240 +r.nextInt(10);
                    break;
                case 3:
                    scale = 270;
                    break;
                default:
                    // code block
            }

            coordinate start = new coordinate(x,y);
            coordinate end = new coordinate(x+scale,y);
            coordinate[] lst = {start,end};
            islandCoordinates.add(lst);
        }
    }
//    ImageView addIsland(int i,int x,int y,int scale,Group root)
    ImageView addIsland(int i,int x,int y,int scale,AnchorPane p)
    {
        String src ="/sample/Island/island_"+i+".png";
        try {
            Image island1 = new Image(src);
            ImageView imageview1 = new ImageView(island1);
            imageview1.setX(x);
            imageview1.setY(y);
            imageview1.setPreserveRatio(true);
            imageview1.setFitWidth(scale);
            p.getChildren().add(imageview1);
            return imageview1;
        }
        catch (Exception e){
            System.out.println("Error in creating an Island...");
        }
        return new ImageView();
    }
}
