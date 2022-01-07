package sample;

public class collision{
    boolean arr[];
    collision() {
        arr = new boolean[4];
        arr[0] = false;     // top
        arr[1] = false;     // bottom
        arr[2] = false;     // right
        arr[3] = false;     // left
    }
    boolean check(gameObject o1, gameObject o2) {
        // Checking top collision
        if (inBetween(o1.getBoundary()[0],o2.getBoundary()[2],o2.getBoundary()[3])){
            arr[0] = true;
            return true;
        }
        if (inBetween(o1.getBoundary()[1],o2.getBoundary()[2],o2.getBoundary()[3])){
            arr[0] = true;
            return true;
        }

        // Checking bottom collision
            System.out.print("O1 ");
            for(int i =0;i<4;i++){
                System.out.print("("+o1.getBoundary()[i].x+","+o1.getBoundary()[i].y+") ");
            }
            System.out.println();
            System.out.print("O2 ");
            for(int i =0;i<4;i++){
                System.out.print("("+o2.getBoundary()[i].x+","+o1.getBoundary()[i].y+") ");
            }
            System.out.println();
            System.out.println("-------------------------");
        if (o1.getBoundary()[2].y<=o2.getBoundary()[0].y) {
            arr[1] =true;
            return  true;
        }
            if (inBetween(o1.getBoundary()[2],o2.getBoundary()[0],o2.getBoundary()[1])){
                arr[1] = true;
                return true;
            }
            if (inBetween(o1.getBoundary()[3],o2.getBoundary()[0],o2.getBoundary()[1])){
                arr[1] = true;
                return true;
            }

        // Checking right collision
        if (inBetween(o1.getBoundary()[1],o2.getBoundary()[0],o2.getBoundary()[3])){
            arr[2] = true;
            return true;
        }
        if (inBetween(o1.getBoundary()[2],o2.getBoundary()[0],o2.getBoundary()[3])){
            arr[2] = true;
            return true;
        }

        // Checking left collision
        if (inBetween(o1.getBoundary()[0],o2.getBoundary()[1],o2.getBoundary()[2])){
            arr[3] = true;
            return true;
        }
        if (inBetween(o1.getBoundary()[3],o2.getBoundary()[1],o2.getBoundary()[2])){
            arr[3] = true;
            return true;
        }
        return false;
    }
    boolean inBetween(coordinate c1, coordinate c2, coordinate c3){
        if (c1.getX()<=c3.getX()&&c1.getX()>=c2.getX()&&c1.getY()==c3.getY()){
            return true;
        }
        if (c1.getY()<=c3.getY()&&c1.getY()>=c2.getY()&&c1.getX()==c3.getX()){
            return true;
        }
        return false;
    }
}